package commands.base;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

/**
 * Command that closes the currently opened JSON file session.
 * <p>
 * If no file is open, a message is returned.
 * This command does not require parameters.
 */
public class CloseCommand implements Command {
    private JsonService service;

    /**
     * Creates a CloseCommand with the given JSON service.
     * @param service the JSON service used for the session
     */
    public CloseCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Executes the close command.
     * <p>
     * It closes the open file if one exists.
     * @param params command arguments; no parameters are expected
     * @return a message showing success, an error if no file is open,
     *         or the command description if parameters are invalid
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();

        if (params.length != 1)
            throw new InvalidCommandException(this.getDescription());

        String fileName = service.getSession().getFilePath();
        service.getSession().closeFile();

        return "Successfully closed " + fileName;
    }

    /**
     * Returns the command usage text.
     * @return the description of the close command
     */
    @Override
    public String getDescription() {
        return "close\tcloses currently opened file\n";
    }
}