package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class PrintCommand extends Command {
    public PrintCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        if (!getJsonService().getSession().isOpen())
            return "No file is currently open.";
        return getJsonService().print();
    }

    @Override
    public String getDescription() {
        return "print\tdisplays the object content in a readable format\n";
    }
}
