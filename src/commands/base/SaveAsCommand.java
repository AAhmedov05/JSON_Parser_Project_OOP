package commands.base;

import contracts.Command;
import session.FileSession;

public class SaveAsCommand extends Command {
    public SaveAsCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "save as <file>\tsaves the currently open file in <file>\n";
    }
}
