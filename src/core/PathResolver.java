package core;

import contracts.JsonValue;
import exceptions.JsonServiceException;

/**
 * Resolves JSON paths.
 */
public class PathResolver {

    /**
     * Resolves a JSON value by path.
     */
    public static JsonValue resolve(JsonValue root, String path) {
        if (path == null || path.isEmpty()) {
            return root;
        }

        String[] parts = path.split("\\.");
        JsonValue current = root;

        for (String part : parts) {
            current = resolvePart(current, part);
        }

        return current;
    }

    /**
     * Returns the parent of the given path.
     */
    public static JsonValue getParent(JsonValue root, String path) {
        int lastDot = path.lastIndexOf(".");
        if (lastDot == -1)
            return root;
        return resolve(root, path.substring(0, lastDot));
    }

    /**
     * Returns the last key from the path.
     */
    public static String getKey(String path) {
        int lastDot = path.lastIndexOf(".");
        String last = (lastDot == -1) ?
                path
                : path.substring(lastDot + 1);
        if (last.contains("["))
            return last.substring(0, last.indexOf("["));
        return last;
    }

    /**
     * Returns array index from path if present.
     */
    public static String getIndex(String path) {
        int lastDot = path.lastIndexOf(".");
        String last = (lastDot == -1) ? path : path.substring(lastDot + 1);

        if (last.contains("[") && last.contains("]"))
            return last.substring(last.indexOf("[") + 1, last.indexOf("]"));
        return null;
    }

    /**
     * Resolves a single path segment.
     */
    private static JsonValue resolvePart(JsonValue current, String part) {
        if (part.contains("[") && part.contains("]")) {
            String key = part.substring(0, part.indexOf("["));
            String index = part.substring(part.indexOf("[") + 1, part.indexOf("]"));

            if (!key.isEmpty()) {
                current = current.get(key);
                if (current == null)
                    throw new JsonServiceException("Path does not exist");
            }
            return current.get(index);
        }

        JsonValue next = current.get(part);
        if (next == null)
            throw new JsonServiceException("Path does not exist");
        return next;
    }
}