package commands;

import contracts.Command;

import java.io.*;

public class OpenCommand implements Command {
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
