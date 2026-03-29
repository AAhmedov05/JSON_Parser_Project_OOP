package commands;

import contracts.Command;

public class SaveAsCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "save as <file>\tsaves the currently open file in <file>\n";
    }
}
