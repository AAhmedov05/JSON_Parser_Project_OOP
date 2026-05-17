package commands;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

/**
 * Moves a JSON element from one path to another.
 */
public class MoveCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public MoveCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Moves an element between paths.
     * @param params source and destination paths
     * @return result message
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();
        if (params.length != 3)
            throw new InvalidCommandException(this.getDescription());
        return service.move(params[1], params[2]);
    }

    /**
     * Returns the command usage text.
     * @return the description of the move command
     */
    @Override
    public String getDescription() {
        return "move <from> <to>\tmoves elements from one path to another\n";
    }
}