package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class SetCommand extends Command {
    public SetCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "set <path> <string>\treplaces value at path with JSON string\n";
    }
}
