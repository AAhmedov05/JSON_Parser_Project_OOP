package exceptions;
/**
 * Exception thrown for JSON parsing errors.
 */
public class JsonParserException extends RuntimeException{
    /**
     * Constructs a new JsonParserException with the specified detail message.
     * @param message the detail message describing the cause of the exception
     */
    public JsonParserException(String message) {
        super(message);
    }
}
