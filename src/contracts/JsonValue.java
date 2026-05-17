package contracts;

import java.util.List;

/**
 * Represents any JSON data type (object, array, or primitive value).
 */
public interface JsonValue {

    JsonValue get(String keyOrIndex);

    void put(String keyOrValue, JsonValue value);

    void set(String keyOrIndex, JsonValue value);

    void remove(String keyOrIndex);

    List<String> findIt(String targetKey, String path, List<String> results);

    String toJson(int indent);
}