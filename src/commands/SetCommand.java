package commands;

import contracts.Command;

public class SetCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "set <path> <string>\treplaces value at path with JSON string\n";
    }
}
