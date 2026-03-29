package commands;

import contracts.Command;

public class DeleteCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "delete <path>\tremoves the element at the given path\n";
    }
}
