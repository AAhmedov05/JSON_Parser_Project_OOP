package json;

import contracts.JsonValue;

public class JsonString implements JsonValue {
    private String value;

    public JsonString(String value) {
        this.value = value;
    }

    @Override
    public String toJson(int indent) {
        return "\""+this.value+"\"";
    }
}