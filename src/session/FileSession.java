package session;

import contracts.JsonValue;
import core.PathResolver;
import exceptions.FileException;
import json.JsonObject;
import parser.JsonParser;

import java.io.*;

/**
 * Manages file operations for a JSON document session.
 */
public class FileSession {

    /** Path of the currently opened file. */
    private String filePath;

    /** Root JSON object in memory. */
    private JsonValue jsonRoot;

    /** Indicates whether a file is open. */
    private boolean isOpen;

    /**
     * Returns current file path.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Returns root JSON object.
     */
    public JsonValue getJsonRoot() {
        return jsonRoot;
    }

    /**
     * Checks if a file is open.
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Opens a JSON file or creates a new one if missing.
     */
    public void openFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
            this.jsonRoot=new JsonObject();
        } else {
            String content = readFromFile(file);

            if (!content.isBlank()) {
                if (content.startsWith("{") || content.startsWith("[")) {
                    jsonRoot = new JsonParser().parse(content);
                } else {
                    throw new FileException("JSON file must start with { or [");
                }
            } else {
                writeToFile(path, new JsonObject().toJson(0));
            }
        }

        this.filePath = path;
        this.isOpen = true;
    }

    /**
     * Closes the current file session.
     */
    public void closeFile() {
        this.filePath = null;
        this.jsonRoot = null;
        this.isOpen = false;
    }

    /**
     * Reads file content as string.
     */
    private String readFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        reader.close();
        return sb.toString();
    }

    /**
     * Saves current JSON to file.
     */
    public void save() throws IOException {
        writeToFile(this.filePath, jsonRoot.toJson(0));
    }

    /**
     * Saves JSON to a new file.
     */
    public void saveAs(String newPath) throws IOException {
        writeToFile(newPath, jsonRoot.toJson(0));
    }

    /**
     * Saves a specific JSON path to a file.
     */
    public void saveAs(String newPath, String path) throws IOException {
        if (!isOpen) {
            throw new FileException("No file is currently open.");
        }

        if (path == null || path.isEmpty()) {
            saveAs(newPath);
            return;
        }

        JsonValue element = PathResolver.resolve(jsonRoot, path);
        JsonValue toSave = element;
        String key = PathResolver.getKey(path);

        if (!key.isEmpty() && !key.matches("\\d+")) {
            JsonObject wrapper = new JsonObject();
            wrapper.put(key, element);
            toSave = wrapper;
        }

        writeToFile(newPath, toSave.toJson(0));
    }

    /**
     * Writes content to a file.
     */
    private void writeToFile(String path, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content != null ? content : "");
        writer.close();
    }
}