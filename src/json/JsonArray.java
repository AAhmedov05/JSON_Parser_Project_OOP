package json;

import contracts.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonValue {
    private List<JsonValue> values;

    public JsonArray() {
        this.values = new ArrayList<>();
    }

    @Override
    public String toJson(int indent) {
        StringBuilder sb=new StringBuilder("[\n");
        for (int i=0;i< values.size();i++){
            sb.append(" ".repeat(indent+2))
                    .append(values.get(i).toJson(indent+2));
            if (i< values.size()-1)
                sb.append(",");
            sb.append("\n");
        }
        sb.append(" ".repeat(indent)).append("]");
        return sb.toString();
    }
}