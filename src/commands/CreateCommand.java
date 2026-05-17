package commands;

import contracts.Command;
import contracts.JsonValue;
import core.JsonService;
import exceptions.InvalidCommandException;
import parser.JsonParser;

/**
 * Creates a new JSON element at a given path.
 */
public class CreateCommand implements Command {

    private JsonService service;

    /**
     * Creates the command with a JSON service.
     */
    public CreateCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Adds a new JSON element.
     *
     * @param params path and value
     * @return result message
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();
        if (params.length != 3)
            throw new InvalidCommandException(this.getDescription());
        String path = params[1];
        String valueStr = params[2];
        JsonValue jsonValue=new JsonParser().parse(valueStr);
        return service.create(path, jsonValue);
    }

    /**
     * Returns the command usage text.
     * @return the description of the create command
     */
    @Override
    public String getDescription() {
        return "create <path> <string>\tadds a new JSON element at the path\n";
    }
}