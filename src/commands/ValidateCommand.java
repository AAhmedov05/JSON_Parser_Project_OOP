package commands;

import contracts.Command;

public class ValidateCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "validate\tchecks if file is valid JSON and reports detailed errors\n";
    }
}
