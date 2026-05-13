package commands.base;

import contracts.Command;
import core.JsonService;

/**
 * Command that exits the application.
 * <p>
 * It prints a message when the program is shutting down.
 */
public class ExitCommand extends Command {

    /**
     * Creates an ExitCommand.
     * @param service the JSON service (not used)
     */
    public ExitCommand(JsonService service) {
        super(service);
    }

    /**
     * Executes the exit command.
     * @param params command arguments; no parameters are needed
     * @return a message that the program is exiting
     */
    @Override
    public String execute(String[] params) {
        return "Exiting the program...";
    }

    /**
     * Returns the command description.
     * @return the exit command usage text
     */
    @Override
    public String getDescription() {
        return "exit\texists the program\n";
    }
}