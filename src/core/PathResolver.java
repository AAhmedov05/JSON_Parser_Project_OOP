package core;

import contracts.JsonValue;
import json.*;

public class PathResolver {
    public static JsonValue resolve(JsonValue root, String path) {
        String[] parts = path.split("\\.");
        JsonValue current = root;
        for (String part : parts) {
            current = resolvePart(current, part);
        }
        return current;
    }

    private static JsonValue resolvePart(JsonValue current, String part) {
        if (part.contains("[") && part.contains("]")) {
            String key = part.substring(0, part.indexOf("["));
            int index = Integer.parseInt(part.substring(part.indexOf("[") + 1, part.indexOf("]")));
            if (!key.isEmpty()) {
                current = ((JsonObject) current).get(key);
            }
            return ((JsonArray) current).getValues().get(index);
        }
        return ((JsonObject) current).get(part);
    }
}
