package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.List;

/**
 * Represents a JSON null value.
 */
public class JsonNull implements JsonValue {

    /**
     * Not supported for null type.
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        throw new JsonStructureException("Cannot get value from null type");
    }

    /**
     * Not supported for null type.
     */
    @Override
    public void put(String keyOrValue, JsonValue value) {
        throw new JsonStructureException("Cannot add value to null type");
    }

    /**
     * Not supported for null type.
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        throw new JsonStructureException("Cannot set value in null type");
    }

    /**
     * Not supported for null type.
     */
    @Override
    public void remove(String keyOrIndex) {
        throw new JsonStructureException("Cannot remove value from null type");
    }

    /**
     * Not supported for null type.
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        return results;
    }

    /**
     * Converts null value to JSON string.
     *
     * @param indent indentation level (unused)
     * @return "null"
     */
    @Override
    public String toJson(int indent) {
        return "null";
    }
}