package commands;

import contracts.Command;

public class ExitCommand implements Command {
    @Override
    public String execute(String params) {
        return "Exiting the program...";
    }

    @Override
    public String getDescription() {
        return "exit\texists the program\n";
    }
}
