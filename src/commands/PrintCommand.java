package commands;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

/**
 * Prints the JSON content in a readable format.
 */
public class PrintCommand implements Command {
    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public PrintCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Displays the current JSON object.
     * @param params no parameters expected
     * @return formatted JSON string
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();
        if (params.length != 1)
            throw new InvalidCommandException(this.getDescription());
        return service.print();
    }

    /**
     * Returns the command usage text.
     * @return the description of the print command
     */
    @Override
    public String getDescription() {
        return "print\tdisplays the object content in a readable format\n";
    }
}