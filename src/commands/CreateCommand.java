package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class CreateCommand extends Command {
    public CreateCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "create <path> <string>\tadds a new JSON element at the path\n";
    }
}
