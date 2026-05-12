package commands.base;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class SaveCommand extends Command {
    public SaveCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "save\tsaves the currently open file\n";
    }
}
