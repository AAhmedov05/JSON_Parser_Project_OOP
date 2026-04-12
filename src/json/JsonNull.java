package json;

import contracts.JsonValue;

public class JsonNull implements JsonValue {

    @Override
    public String toJson(int indent) {
        return "null";
    }
}