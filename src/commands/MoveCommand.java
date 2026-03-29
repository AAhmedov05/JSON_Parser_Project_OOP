package commands;

import contracts.Command;

public class MoveCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "move <from> <to>\tmoves elements from one path to another\n";
    }
}
