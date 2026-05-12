package commands.base;

import contracts.Command;
import core.JsonService;
import session.FileSession;

import java.io.IOException;

public class SaveAsCommand extends Command {
    public SaveAsCommand(JsonService service) {
        super(service);
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
