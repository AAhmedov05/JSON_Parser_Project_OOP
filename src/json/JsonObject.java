package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a JSON object (key-value pairs).
 */
public class JsonObject implements JsonValue {

    /** Stores JSON fields in insertion order. */
    private Map<String, JsonValue> objects;

    /**
     * Returns internal map of values.
     */
    public Map<String, JsonValue> getValues() {
        return this.objects;
    }

    /**
     * Creates an empty JSON object.
     */
    public JsonObject() {
        this.objects = new LinkedHashMap<>();
    }

    /**
     * Gets value by key.
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        return objects.get(keyOrIndex);
    }

    /**
     * Adds a new key-value pair.
     */
    @Override
    public void put(String keyOrIndex, JsonValue value) {
        objects.put(keyOrIndex, value);
    }

    /**
     * Updates existing key.
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        if (!objects.containsKey(keyOrIndex)) {
            throw new JsonStructureException("Key does not exist");
        }
        objects.put(keyOrIndex, value);
    }

    /**
     * Removes a key-value pair.
     */
    @Override
    public void remove(String keyOrIndex) {
        if (!objects.containsKey(keyOrIndex)) {
            throw new JsonStructureException("Key does not exist");
        }
        objects.remove(keyOrIndex);
    }

    /**
     * Searches recursively for matching keys.
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        for (Map.Entry<String, JsonValue> entry : objects.entrySet()) {
            String newPath = path.isEmpty()
                    ? entry.getKey()
                    : path + "." + entry.getKey();
            if (entry.getKey().equals(targetKey)) {
                results.add(newPath + " = " + entry.getValue().toJson(0));
            }
            entry.getValue().findIt(targetKey, newPath, results);
        }
        return results;
    }

    /**
     * Converts object to JSON string.
     */
    @Override
    public String toJson(int indent) {
        StringBuilder sb = new StringBuilder("{\n");
        int counter = 0;

        for (Map.Entry<String, JsonValue> entry : objects.entrySet()) {
            sb.append(" ".repeat(indent + 2))
                    .append("\"")
                    .append(entry.getKey()).append("\": ")
                    .append(entry.getValue().toJson(indent + 2));
            counter++;
            if (counter < objects.size()) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append(" ".repeat(indent)).append("}");
        return sb.toString();
    }
}