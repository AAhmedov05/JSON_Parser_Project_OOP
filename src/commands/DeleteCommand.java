package commands;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

/**
 * Deletes a JSON element at a given path.
 */
public class DeleteCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public DeleteCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Removes an element from JSON.
     * @param params path to delete
     * @return result message
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();
        if (params.length != 2)
            throw new InvalidCommandException(this.getDescription());
        return service.delete(params[1]);
    }

    /**
     * Returns the command usage text.
     * @return the description of the delete command
     */
    @Override
    public String getDescription() {
        return "delete <path>\tremoves the element at the given path\n";
    }
}