package commands.base;

import contracts.Command;
import session.FileSession;

public class SaveCommand extends Command {
    public SaveCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "save\tsaves the currently open file\n";
    }
}
