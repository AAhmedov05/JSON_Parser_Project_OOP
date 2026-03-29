package commands;

import contracts.Command;

public class SaveCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "save\tsaves the currently open file\n";
    }
}
