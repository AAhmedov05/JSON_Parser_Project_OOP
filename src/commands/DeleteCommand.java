package commands;

import contracts.Command;
import session.FileSession;

public class DeleteCommand extends Command {
    public DeleteCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "delete <path>\tremoves the element at the given path\n";
    }
}
