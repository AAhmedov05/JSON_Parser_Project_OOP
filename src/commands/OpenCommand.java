package commands;

import java.io.*;

public class OpenCommand implements Command {
    @Override
    public void execute(String params) {
        File file=new File(params);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            CommandsValidationMessages.fileOpened(file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
