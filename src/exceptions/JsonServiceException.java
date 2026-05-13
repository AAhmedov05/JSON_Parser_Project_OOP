package exceptions;
/**
 * Exception thrown for JSON service errors.
 */
public class JsonServiceException extends RuntimeException {
    /**
     * Constructs a new JsonServiceException with the specified detail message.
     * @param message the detail message describing the cause of the exception
     */
    public JsonServiceException(String message) {
        super(message);
    }
}
