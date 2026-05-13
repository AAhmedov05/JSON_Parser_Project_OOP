package session;

import contracts.JsonValue;
import core.PathResolver;
import exceptions.FileException;
import json.JsonObject;
import parser.JsonParser;

import java.io.*;

public class FileSession {
    private String filePath;
    private JsonValue jsonRoot;
    private boolean isOpen;

    public String getFilePath() {
        return filePath;
    }

    public JsonValue getJsonRoot() {
        return jsonRoot;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void openFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
            this.jsonRoot=new JsonObject();
        } else {
            jsonRoot=new JsonParser().parse(readFromFile(file));
        }
        this.filePath = path;
        this.isOpen = true;
    }

    public void closeFile(){
        this.filePath=null;
        this.jsonRoot=null;
        this.isOpen=false;
    }

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

    public void save() throws IOException {
        writeToFile(this.filePath, jsonRoot.toJson(0));
    }

    public void saveAs(String newPath) throws IOException {
        writeToFile(newPath, jsonRoot.toJson(0));
    }

    public void saveAs(String newPath, String path) throws IOException {
        if (!isOpen) {
            throw new FileException("No file is currently open.");
        }
        if (path == null || path.isEmpty()) {
            saveAs(newPath);
            return;
        }
        JsonValue element = PathResolver.resolve(jsonRoot, path);
        if (element == null) {
            throw new FileException("Invalid path: " + path);
        }
        JsonValue toSave = element;
        String lastPart = path;
        if (path.contains(".")) {
            lastPart = path.substring(path.lastIndexOf('.') + 1);
        }
        if (lastPart.contains("[")) {
            lastPart = lastPart.substring(0, lastPart.indexOf('['));
        }
        if (!lastPart.isEmpty() && !lastPart.matches("\\d+")) {
            JsonObject wrapper = new JsonObject();
            wrapper.put(lastPart, element);
            toSave = wrapper;
        }
        writeToFile(newPath, toSave.toJson(0));
    }

    private void writeToFile(String path, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content != null ? content : "");
        writer.close();
    }
}
