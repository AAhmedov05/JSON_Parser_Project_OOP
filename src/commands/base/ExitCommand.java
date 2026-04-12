package commands.base;

import contracts.Command;
import session.FileSession;

public class ExitCommand extends Command {
    public ExitCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String params) {
        session.closeFile();
        return "Exiting the program...";
    }

    @Override
    public String getDescription() {
        return "exit\texists the program\n";
    }
}
