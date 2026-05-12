package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class DeleteCommand extends Command {
    public DeleteCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "delete <path>\tremoves the element at the given path\n";
    }
}
