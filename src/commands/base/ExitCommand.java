package commands.base;

import contracts.Command;
import exceptions.InvalidCommandException;

/**
 * Command that exits the application.
 * <p>
 * It prints a message when the program is shutting down.
 */
public class ExitCommand implements Command {

    /**
     * Executes the exit command.
     * @param params command arguments; no parameters are needed
     * @return a message that the program is exiting
     */
    @Override
    public String execute(String[] params) {
        if (params.length != 1)
            throw new InvalidCommandException(this.getDescription());

        return "Exiting the program...";
    }

    /**
     * Returns the command description.
     * @return the exit command usage text
     */
    @Override
    public String getDescription() {
        return "exit\texits the program\n";
    }
}