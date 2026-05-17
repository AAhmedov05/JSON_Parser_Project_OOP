package commands;

import contracts.Command;
import core.JsonService;
import exceptions.InvalidCommandException;

/**
 * Searches JSON values by key.
 */
public class SearchCommand implements Command {

    /** JSON service used for operations. */
    private JsonService service;

    /**
     * Creates the command.
     */
    public SearchCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Executes search by key.
     *
     * @param params key to search
     * @return search result
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();

        if (params.length != 2)
            throw new InvalidCommandException(this.getDescription());

        return service.search(params[1]);
    }

    /**
     * Returns the command usage text.
     * @return the description of the search command
     */
    @Override
    public String getDescription() {
        return "search <key>\tfinds all values by key and lists them if present\n";
    }
}