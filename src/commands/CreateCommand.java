package commands;

import contracts.Command;

public class CreateCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "create <path> <string>\tadds a new JSON element at the path\n";
    }
}
