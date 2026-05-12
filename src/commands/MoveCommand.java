package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class MoveCommand extends Command {
    public MoveCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "move <from> <to>\tmoves elements from one path to another\n";
    }
}
