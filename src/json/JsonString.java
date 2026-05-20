package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.List;

/**
 * Represents a JSON string value.
 */
public class JsonString implements JsonValue {

    /** Stored string value. */
    private String value;

    /**
     * Creates a JSON string
     * @param value string to store
     */
    public JsonString(String value) {
        this.value = value;
    }

    /**
     * Returns stored value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Not supported for string type
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        return results;
    }

    /**
     * Not supported for string type
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        throw new JsonStructureException("Cannot get value from string type");
    }

    /**
     * Not supported for string type
     */
    @Override
    public void put(String keyOrValue, JsonValue value) {
        throw new JsonStructureException("Cannot add value to string type");
    }

    /**
     * Not supported for string type
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        throw new JsonStructureException("Cannot set value in string type");
    }

    /**
     * Not supported for string type
     */
    @Override
    public void remove(String keyOrIndex) {
        throw new JsonStructureException("Cannot remove value from string type");
    }

    /**
     * Converts string to JSON format
     * @param indent indentation level (unused)
     * @return JSON-escaped string
     */
    @Override
    public String toJson(int indent) {
        return "\"" + escape(value) + "\"";
    }

    /**
     * Escapes special characters for JSON output.
     */
    private String escape(String text) {
        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t")
                .replace("\r", "\\r");
    }
}