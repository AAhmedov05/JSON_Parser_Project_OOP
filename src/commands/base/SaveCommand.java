package commands.base;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

import java.io.IOException;

/**
 * Saves the current JSON file.
 */
public class SaveCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public SaveCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Saves the current file or saves it to a given path.
     *
     * @param params optional file path
     * @return success message
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();

        try {
            if (params.length == 1)
                service.getSession().save();
            else if (params.length == 2){
                service.getSession().saveAs(params[1]);
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
     * @return the description of the save command
     */
    @Override
    public String getDescription() {
        return "save\tsaves the currently open file\nsave [<path>]\tsaves current object or object at <path>\n";
    }
}