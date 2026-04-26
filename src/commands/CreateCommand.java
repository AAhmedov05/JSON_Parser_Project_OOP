package commands;

import contracts.Command;
import session.FileSession;

public class CreateCommand extends Command {
    public CreateCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "create <path> <string>\tadds a new JSON element at the path\n";
    }
}
