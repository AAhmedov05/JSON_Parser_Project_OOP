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
        if (!params[1].toLowerCase().endsWith(".json"))  return "File must have .json extension.";
        try {
            session.openFile(params[1]);
            return "Successfully opened "+session.getFilePath()
                    .substring(session.getFilePath().lastIndexOf('\\')+1);
        } catch (IOException e) {
            return "Failed to open file: " + e.getMessage();
        }
    }

    @Override
    public String getDescription() {
        return "open <file>\topens <file>\n";
    }
}
