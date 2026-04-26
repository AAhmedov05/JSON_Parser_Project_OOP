package commands.base;

import contracts.Command;
import session.FileSession;

import java.io.*;

public class OpenCommand extends Command {
    public OpenCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        if (params.length < 2) return this.getDescription();
        try {
            session.openFile(params[1]);
            return "File opened successfully.";
        } catch (IOException e) {
            return "Failed to open file: " + e.getMessage();
        }
    }

    @Override
    public String getDescription() {
        return "open <file>\topens <file>\n";
    }
}
