package commands;

import contracts.Command;
import core.JsonService;

/**
 * Validates the current JSON file.
 */
public class ValidateCommand implements Command {

    /** JSON service used for operations */
    private JsonService service;

    /**
     * Creates the command
     */
    public ValidateCommand(JsonService service) {
        this.service = service;
    }

    /**
     * Validates JSON structure
     * @param params no parameters expected
     * @return validation result
     */
    @Override
    public String execute(String[] params) {
        service.isJsonOpen();

        if (params.length != 1)
            return this.getDescription();

        return service.validate();
    }

    /**
     * Returns the command usage text.
     * @return the description of the validate command
     */
    @Override
    public String getDescription() {
        return "validate\tchecks if file is valid JSON and reports detailed errors\n";
    }
}