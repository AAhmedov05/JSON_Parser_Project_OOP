package commands.base;

import contracts.Command;
import core.JsonService;
import session.FileSession;

import java.io.*;

public class OpenCommand extends Command {
    public OpenCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        if (params.length < 2) return this.getDescription();
        if (!params[1].toLowerCase().endsWith(".json"))  return "File must have .json extension.";
        try {
            getJsonService().getSession().openFile(params[1]);
            return "Successfully opened "+getJsonService().getSession().getFilePath()
                    .substring(getJsonService().getSession().getFilePath().lastIndexOf('\\')+1);
        } catch (IOException e) {
            return "Failed to open file: " + e.getMessage();
        }
    }

    @Override
    public String getDescription() {
        return "open <file>\topens <file>\n";
    }
}
