package parser;
import contracts.JsonValue;
import json.*;

public class JsonParser {
    private String input;
    private int index;
    private int line;

    private void skipWhitespace() {
        while (index < input.length()) {
            char c = input.charAt(index);
            if (c == '\n') {
                line++;
            }
            if (!Character.isWhitespace(c)) {
                break;
            }
            index++;
        }
    }

    private JsonNull parseNull() {
        if (input.startsWith("null", index)) {
            index += 4;
            return new JsonNull();
        }
        throw new RuntimeException("Invalid null at line " + line);
    }

    private JsonBoolean parseBoolean() {
        if (input.startsWith("true", index)) {
            index += 4;
            return new JsonBoolean(true);
        }
        if (input.startsWith("false", index)) {
            index += 5;
            return new JsonBoolean(false);
        }
        throw new RuntimeException("Invalid boolean at line " + line);
    }

    public JsonValue parse(String input) {
        this.input = input;
        this.index = 0;
        this.line = 0;

        skipWhitespace();
        JsonValue value = parseValue();
        skipWhitespace();
        if (index != input.length()) {
            throw new RuntimeException("Unexpected trailing characters at line " + line);
        }
        return value;
    }

    private JsonValue parseValue() {
        skipWhitespace();
        if (index >= input.length()) {
            throw new RuntimeException("Unexpected end of input at line " + line);
        }

        char c = input.charAt(index);

        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (c == 't' || c == 'f') return parseBoolean();
        if (c == 'n') return parseNull();
        if (c == '-' || Character.isDigit(c)) return parseNumber();

        throw new RuntimeException("Unexpected character '" + c + "' at line " + line);
    }

    private JsonNumber parseNumber() {
        int start = index;
        if (input.charAt(index) == '-') index++;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }
        if (index < input.length() && input.charAt(index) == '.') {
            index++;
            while (index < input.length() && Character.isDigit(input.charAt(index))) {
                index++;
            }
        }
        double value = Double.parseDouble(input.substring(start, index));
        return new JsonNumber(value);
    }

    private JsonString parseString() {
        index++;
        StringBuilder sb = new StringBuilder();

        while (index < input.length()) {
            char c = input.charAt(index);

            if (c == '\n') line++;
            if (c == '"') {
                index++;
                return new JsonString(sb.toString());
            }
            if (c == '\\') {
                index++;
                if (index >= input.length()) {
                    throw new RuntimeException("Invalid escape at line " + line);
                }

                char next = input.charAt(index);
                switch (next) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    default:
                        throw new RuntimeException("Invalid escape sequence at line " + line);
                }
            } else {
                sb.append(c);
            }
            index++;
        }
        throw new RuntimeException("Unterminated string at line " + line);
    }

    private JsonObject parseObject() {
        JsonObject obj = new JsonObject();
        index++;

        skipWhitespace();
        if (index < input.length() && input.charAt(index) == '}') {
            index++;
            return obj;
        }
        while (true) {
            skipWhitespace();
            if (index >= input.length() || input.charAt(index) != '"') {
                throw new RuntimeException("Expected string key at line " + line);
            }

            String key = parseString().getValue();

            skipWhitespace();
            if (index >= input.length() || input.charAt(index) != ':') {
                throw new RuntimeException("Expected ':' at line " + line);
            }
            index++;
            skipWhitespace();
            JsonValue value = parseValue();
            obj.put(key, value);
            skipWhitespace();
            if (index >= input.length()) {
                throw new RuntimeException("Unexpected end of object at line " + line);
            }
            char c = input.charAt(index);
            if (c == '}') {
                index++;
                break;
            }
            if (c != ',') {
                throw new RuntimeException("Expected ',' or '}' at line " + line);
            }
            index++;
        }
        return obj;
    }

    private JsonArray parseArray() {
        JsonArray arr = new JsonArray();
        index++;
        skipWhitespace();

        if (index < input.length() && input.charAt(index) == ']') {
            index++;
            return arr;
        }
        while (true) {
            skipWhitespace();
            if (index >= input.length()) {
                throw new RuntimeException("Unexpected end of array at line " + line);
            }

            arr.getValues().add(parseValue());
            skipWhitespace();
            if (index >= input.length()) {
                throw new RuntimeException("Unexpected end of array at line " + line);
            }

            char c = input.charAt(index);
            if (c == ']') {
                index++;
                break;
            }
            if (c != ',') {
                throw new RuntimeException("Expected ',' or ']' at line " + line);
            }
            index++;
        }
        return arr;
    }
}