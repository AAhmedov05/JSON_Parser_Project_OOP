package commands;

import contracts.Command;

public class PrintCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "print\tdisplays the object content in a readable format\n";
    }
}
