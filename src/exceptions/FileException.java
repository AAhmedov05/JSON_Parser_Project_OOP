package exceptions;
/**
 * Exception thrown for file operation errors.
 */
public class FileException extends RuntimeException {
    /**
     * Constructs a new FileException with the specified detail message.
     * @param message the detail message describing the cause of the exception
     */
    public FileException(String message) {
        super(message);
    }
}
