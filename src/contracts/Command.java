package contracts;

/**
 * Represents a system command.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @param params command arguments
     * @return result message
     */
    String execute(String[] params);

    /**
     * Returns command usage.
     *
     * @return description text
     */
    String getDescription();
}