package commands.base;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

import java.io.IOException;

/**
 * Opens a JSON file.
 */
public class OpenCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public OpenCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Opens a .json file.
     *
     * @param params file name
     * @return success or error message
     */
    @Override
    public String execute(String[] params) {
        if (params.length != 2)
            throw new InvalidCommandException(this.getDescription());

        if (!params[1].toLowerCase().endsWith(".json"))
            return "File must have .json extension.";

        try {
            service.getSession().openFile(params[1]);
            return "Successfully opened " + params[1];
        } catch (IOException e) {
            return "Failed to open file: " + e.getMessage();
        }
    }

    /**
     * Returns the command usage text.
     * @return the description of the open command
     */
    @Override
    public String getDescription() {
        return "open <file>\topens <file>\n";
    }
}