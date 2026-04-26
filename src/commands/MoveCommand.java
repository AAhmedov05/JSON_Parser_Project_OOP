package commands;

import contracts.Command;
import session.FileSession;

public class MoveCommand extends Command {
    public MoveCommand(FileSession session) {
        super(session);
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
