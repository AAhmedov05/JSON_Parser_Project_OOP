package commands;

import contracts.Command;
import contracts.JsonValue;
import core.JsonService;
import exceptions.InvalidCommandException;
import parser.JsonParser;

import java.util.Arrays;

/**
 * Replaces a JSON value at a given path
 */
public class SetCommand implements Command {

    /** JSON service used for operations */
    private JsonService service;

    /**
     * Creates the command
     */
    public SetCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Sets a value at a JSON path.
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
        String valueStr = String.join(" ", Arrays.copyOfRange(params, 2, params.length));
        JsonValue value = new JsonParser().parse(valueStr);

        return service.set(path, value);
    }

    /**
     * Returns the command usage text.
     * @return the description of the set command
     */
    @Override
    public String getDescription() {
        return "set <path> <string>\treplaces value at path with JSON string\n";
    }
}