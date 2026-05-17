package json;

import contracts.JsonValue;
import exceptions.JsonStructureException;

import java.util.List;

/**
 * Represents a JSON number value.
 */
public class JsonNumber implements JsonValue {

    /** Stored numeric value. */
    private double value;

    /**
     * Creates a JSON number.
     *
     * @param value number to store
     */
    public JsonNumber(double value) {
        this.value = value;
    }

    /**
     * Not supported for number type.
     */
    @Override
    public JsonValue get(String keyOrIndex) {
        throw new JsonStructureException("Cannot get value from number type");
    }

    /**
     * Not supported for number type.
     */
    @Override
    public void put(String keyOrValue, JsonValue value) {
        throw new JsonStructureException("Cannot add value to number type");
    }

    /**
     * Not supported for number type.
     */
    @Override
    public void set(String keyOrIndex, JsonValue value) {
        throw new JsonStructureException("Cannot set value in number type");
    }

    /**
     * Not supported for number type.
     */
    @Override
    public void remove(String keyOrIndex) {
        throw new JsonStructureException("Cannot remove value from number type");
    }

    /**
     * Not supported for number type.
     */
    @Override
    public List<String> findIt(String targetKey, String path, List<String> results) {
        return results;
    }

    /**
     * Converts number to JSON string.
     * @param indent indentation level (unused)
     * @return number as string
     */
    @Override
    public String toJson(int indent) {
        return String.valueOf(this.value);
    }
}