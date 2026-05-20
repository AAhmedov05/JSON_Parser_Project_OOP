package commands.base;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

import java.io.IOException;

/**
 * Saves the current JSON file under a new name or path.
 */
public class SaveAsCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public SaveAsCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Saves the current file.
     *
     * @param params file name and optional path
     * @return success message
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();

        try {
            if (params.length == 2)
                service.getSession().saveAs(params[1]);
            else if (params.length == 3){
                service.getSession().saveAs(params[1], params[2]);
                return "Successfully saved " + params[1];
            }
            else
                throw new InvalidCommandException(this.getDescription());

        } catch (IOException e) {
            throw new InvalidCommandException(e.getMessage());
        }

        return "Successfully saved " + service.getSession().getFilePath();
    }

    /**
     * Returns the command usage text.
     * @return the description of the save as command
     */
    @Override
    public String getDescription() {
        return "save as <file>\tsaves the currently open file in <file>\nsave as <file> [<path>]\tsaves object to <file>\n";
    }
}