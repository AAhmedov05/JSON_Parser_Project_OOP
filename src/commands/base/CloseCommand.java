package commands.base;

import contracts.Command;
import session.FileSession;

public class CloseCommand extends Command {
    public CloseCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String params) {
        if (!session.isOpen())
            return "No file is currently open.";
        String fileName= session.getFilePath();
        session.closeFile();
        return "Successfully closed "+fileName;
    }

    @Override
    public String getDescription() {
        return "close\tcloses currently opened file\n";
    }
}
