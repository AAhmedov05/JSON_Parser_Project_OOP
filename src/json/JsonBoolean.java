package json;

import contracts.JsonValue;

public class JsonBoolean implements JsonValue {
    private boolean value;

    public JsonBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public String toJson(int indent) {
        return String.valueOf(this.value);
    }
}