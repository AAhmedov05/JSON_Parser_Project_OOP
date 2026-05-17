package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.List;

/**
 * Represents a JSON boolean value.
 */
public class JsonBoolean implements JsonValue {

    /** Stored boolean value. */
    private boolean value;

    /**
     * Returns stored value.
     */
    public boolean isValue() {
        return value;
    }

    /**
     * Creates a JSON boolean.
     */
    public JsonBoolean(boolean value) {
        this.value = value;
    }

    /**
     * Not supported for primitive type.
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        throw new JsonStructureException("Cannot get value from primitive type");
    }

    /**
     * Not supported for primitive type.
     */
    @Override
    public void put(String keyOrValue, JsonValue value) {
        throw new JsonStructureException("Cannot add value to primitive type");
    }

    /**
     * Not supported for primitive type.
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        throw new JsonStructureException("Cannot set value in primitive type");
    }

    /**
     * Not supported for primitive type.
     */
    @Override
    public void remove(String keyOrIndex) {
        throw new JsonStructureException("Cannot remove value from primitive type");
    }

    /**
     * Not supported for primitive type.
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        return results;
    }

    /**
     * Converts boolean to JSON string.
     */
    @Override
    public String toJson(int indent) {
        return String.valueOf(this.value);
    }
}