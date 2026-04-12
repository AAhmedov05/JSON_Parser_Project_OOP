package json;

import contracts.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonValue {
    private List<JsonValue> values=new ArrayList<>();
    @Override
    public String toJson(int indent) {
        return "";
    }
}