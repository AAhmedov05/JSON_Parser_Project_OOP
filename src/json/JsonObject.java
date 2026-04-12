package json;

import contracts.JsonValue;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject implements JsonValue {
    private Map<String,JsonValue> objects=new LinkedHashMap<>();
    @Override
    public String toJson(int indent) {
        return "";
    }
}