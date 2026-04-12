package json;

import contracts.JsonValue;

public class JsonNumber implements JsonValue {
    private double value;

    public JsonNumber(double value) {
        this.value = value;
    }

    @Override
    public String toJson(int indent) {
        return String.valueOf(this.value);
    }
}