package commands.base;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class ExitCommand extends Command {
    public ExitCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "Exiting the program...";
    }

    @Override
    public String getDescription() {
        return "exit\texists the program\n";
    }
}
