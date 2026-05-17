package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a JSON array.
 */
public class JsonArray implements JsonValue {

    /** Stored JSON elements. */
    private List<JsonValue> values;

    /**
     * Returns internal list of values.
     */
    public List<JsonValue> getValues() {
        return values;
    }

    /**
     * Creates an empty JSON array.
     */
    public JsonArray() {
        this.values = new ArrayList<>();
    }

    /**
     * Gets value at index.
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        int index = Integer.parseInt(keyOrIndex);
        validateIndex(index);
        return values.get(index);
    }

    /**
     * Adds a value at index.
     */
    @Override
    public void put(String keyOrIndex, JsonValue value) {
        int index = Integer.parseInt(keyOrIndex);
        if (values.size() > index)
            throw new JsonStructureException("Already exists");
        values.add(index, value);
    }

    /**
     * Replaces value at index.
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        int index = Integer.parseInt(keyOrIndex);
        values.set(index, value);
    }

    /**
     * Removes value at index.
     */
    @Override
    public void remove(String keyOrIndex) {
        int index = Integer.parseInt(keyOrIndex);
        values.remove(index);
    }

    /**
     * Validates index bounds.
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= values.size()) {
            throw new JsonStructureException("Index out of bounds");
        }
    }

    /**
     * Searches recursively for matching keys.
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        for (int i = 0; i < values.size(); i++) {
            String newPath = path + "[" + i + "]";
            values.get(i).findIt(targetKey, newPath, results);
        }
        return results;
    }

    /**
     * Converts array to JSON string.
     */
    @Override
    public String toJson(int indent) {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < values.size(); i++) {
            sb.append(" ".repeat(indent + 2))
                    .append(values.get(i).toJson(indent + 2));
            if (i < values.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append(" ".repeat(indent)).append("]");
        return sb.toString();
    }
}