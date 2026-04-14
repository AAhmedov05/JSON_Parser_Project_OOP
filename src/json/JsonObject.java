package json;

import contracts.JsonValue;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject implements JsonValue {
    private Map<String,JsonValue> objects;

    public JsonObject() {
        this.objects=new LinkedHashMap<>();
    }

    @Override
    public String toJson(int indent) {
        StringBuilder sb=new StringBuilder("{\n");
        int i=0;
        for (Map.Entry<String,JsonValue> entry: objects.entrySet()){
            sb.append(" ".repeat(indent+2))
                    .append("\"")
                    .append(entry.getKey()).append("\": ")
                    .append(entry.getValue().toJson(indent+2));
            if (++i<objects.size())
                sb.append(",");
            sb.append("\n");
        }
        sb.append(" ".repeat(indent)).append("}");
        return sb.toString();
    }
}