package commands;

import contracts.Command;
import session.FileSession;

public class PrintCommand extends Command {
    public PrintCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "print\tdisplays the object content in a readable format\n";
    }
}
