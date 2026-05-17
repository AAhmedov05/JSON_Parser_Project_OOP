package core;

import contracts.JsonValue;
import exceptions.FileException;
import exceptions.JsonServiceException;
import parser.JsonParser;
import session.FileSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides operations for working with a JSON file.
 */
public class JsonService {

    /** Active file session containing JSON data. */
    private FileSession session;

    /**
     * Creates service with a file session.
     */
    public JsonService(FileSession session) {
        this.session = session;
    }

    /**
     * Returns current file session.
     */
    public FileSession getSession() {
        return session;
    }

    /**
     * Checks if a JSON file is open.
     */
    public void isJsonOpen() {
        if (!session.isOpen())
            throw new FileException("No file is currently open");
    }

    /**
     * Returns formatted JSON as string.
     */
    public String print() {
        return session.getJsonRoot().toJson(0);
    }

    /**
     * Searches JSON by key.
     */
    public String search(String key) {
        List<String> results = new ArrayList<>();
        session.getJsonRoot().findIt(key, "", results);

        if (results.isEmpty())
            throw new JsonServiceException("No matches found");

        return String.join("\n", results);
    }

    /**
     * Validates current JSON structure.
     */
    public String validate() {
        try {
            new JsonParser().parse(session.getJsonRoot().toJson(0));
            return "valid";
        } catch (JsonServiceException e) {
            throw new JsonServiceException(e.getMessage());
        }
    }

    /**
     * Creates a new JSON element at path.
     */
    public String create(String path, JsonValue value) {
        JsonValue parent = PathResolver.getParent(session.getJsonRoot(), path);
        String key = PathResolver.getKey(path);
        String index = PathResolver.getIndex(path);

        if (index != null) {
            JsonValue array = (key.isEmpty()) ? parent : parent.get(key);
            array.put(index, value);
            return "Created successfully";
        }

        if (parent.get(key) != null)
            throw new JsonServiceException("Element already exists");

        parent.put(key, value);
        return "Created successfully";
    }

    /**
     * Updates JSON value at path.
     */
    public String set(String path, JsonValue value) {
        JsonValue parent = PathResolver.getParent(session.getJsonRoot(), path);
        String key = PathResolver.getKey(path);
        String index = PathResolver.getIndex(path);

        if (index != null) {
            JsonValue array = (key.isEmpty()) ? parent : parent.get(key);
            array.set(index, value);
            return "Updated successfully";
        }

        parent.set(key, value);
        return "Updated successfully";
    }

    /**
     * Deletes JSON element at path.
     */
    public String delete(String path) {
        JsonValue parent = PathResolver.getParent(session.getJsonRoot(), path);
        String key = PathResolver.getKey(path);
        String index = PathResolver.getIndex(path);

        if (index != null) {
            JsonValue array = (key.isEmpty()) ? parent : parent.get(key);
            array.remove(index);
            return "Deleted successfully";
        }

        parent.remove(key);
        return "Deleted successfully";
    }

    /**
     * Moves a JSON element from one path to another.
     */
    public String move(String from, String to) {
        JsonValue value = PathResolver.resolve(session.getJsonRoot(), from);
        delete(from);
        create(to, value);
        return "Moved successfully";
    }
}