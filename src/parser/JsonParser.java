package parser;

import contracts.JsonValue;
import exceptions.JsonParserException;
import json.*;

/**
 * A simple JSON parser.
 * This class converts a JSON string into a tree of JsonValue objects.
 */
public class JsonParser {
    private String input;
    private int index;
    private int line;

    /**
     * Parses a JSON string into a JsonValue structure.
     *
     * @param input the JSON text
     * @return the parsed JsonValue
     */
    public JsonValue parse(String input) {
        this.input = input;
        this.index = 0;
        this.line = 0;

        skipWhitespace();
        JsonValue value = parseValue();
        skipWhitespace();

        if (index != input.length()) {
            throw new JsonParserException("Unexpected trailing characters at line " + line);
        }
        return value;
    }

    /**
     * Skips whitespace characters in the input.
     * Also tracks new lines for error reporting.
     */
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

    /**
     * Parses any JSON value.
     *
     * @return a JsonValue instance
     */
    private JsonValue parseValue() {
        skipWhitespace();

        if (index >= input.length()) {
            throw new JsonParserException("Unexpected end of input at line " + line);
        }

        char c = input.charAt(index);

        if (c == '{') return parseObject();
        if (c == '[') return parseArray();
        if (c == '"') return parseString();
        if (c == 't' || c == 'f') return parseBoolean();
        if (c == 'n') return parseNull();
        if (c == '-' || Character.isDigit(c)) return parseNumber();

        throw new JsonParserException("Unexpected character '" + c + "' at line " + line);
    }

    /**
     * Parses a JSON null value.
     */
    private JsonNull parseNull() {
        if (input.startsWith("null", index)) {
            index += 4;
            return new JsonNull();
        }
        throw new JsonParserException("Invalid null at line " + line);
    }

    /**
     * Parses a JSON boolean value.
     */
    private JsonBoolean parseBoolean() {
        if (input.startsWith("true", index)) {
            index += 4;
            return new JsonBoolean(true);
        }
        if (input.startsWith("false", index)) {
            index += 5;
            return new JsonBoolean(false);
        }
        throw new JsonParserException("Invalid boolean at line " + line);
    }

    /**
     * Parses a JSON number value.
     */
    private JsonNumber parseNumber() {
        int start = index;
        if (input.charAt(index) == '-') index++;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }

        if (index < input.length() && input.charAt(index) == '.') {
            index++;

            while (index < input.length() &&
                    Character.isDigit(input.charAt(index))) {
                index++;
            }
        }
        double value = Double.parseDouble(input.substring(start, index));
        return new JsonNumber(value);
    }

    /**
     * Parses a JSON string value.
     */
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
                    throw new JsonParserException("Invalid escape at line " + line);
                }

                char next = input.charAt(index);
                switch (next) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    default:
                        throw new JsonParserException("Invalid escape sequence at line " + line);
                }
            } else {
                sb.append(c);
            }
            index++;
        }
        throw new JsonParserException("Unterminated string at line " + line);
    }

    /**
     * Parses a JSON object.
     */
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
                throw new JsonParserException("Expected string key at line " + line);
            }

            String key = parseString().getValue();
            skipWhitespace();
            if (index >= input.length() || input.charAt(index) != ':') {
                throw new JsonParserException("Expected ':' at line " + line);
            }

            index++;
            skipWhitespace();
            JsonValue value = parseValue();
            obj.put(key, value);

            skipWhitespace();
            if (index >= input.length()) {
                throw new JsonParserException("Unexpected end of object at line " + line);
            }

            char c = input.charAt(index);
            if (c == '}') {
                index++;
                break;
            }
            if (c != ',') {
                throw new JsonParserException("Expected ',' or '}' at line " + line);
            }
            index++;
        }
        return obj;
    }

    /**
     * Parses a JSON array.
     */
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
                throw new JsonParserException("Unexpected end of array at line " + line);
            }
            arr.getValues().add(parseValue());
            skipWhitespace();
            if (index >= input.length()) {
                throw new JsonParserException("Unexpected end of array at line " + line);
            }

            char c = input.charAt(index);
            if (c == ']') {
                index++;
                break;
            }
            if (c != ',') {
                throw new JsonParserException("Expected ',' or ']' at line " + line);
            }
            index++;
        }
        return arr;
    }
}