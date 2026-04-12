package commands.base;

import contracts.Command;
import session.FileSession;

import java.io.*;

public class OpenCommand extends Command {
    public OpenCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String params) {
        File file=new File(params);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Successfully opened "+file.getName();
    }

    @Override
    public String getDescription() {
        return "open <file>\topens <file>\n";
    }
}
