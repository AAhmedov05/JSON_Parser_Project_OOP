package exceptions;

/**
 * Thrown when a command is invalid.
 */
public class InvalidCommandException extends RuntimeException {

    /**
     * Creates a new exception with a message.
     * @param message the error message
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}