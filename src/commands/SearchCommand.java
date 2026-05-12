package commands;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class SearchCommand extends Command {
    public SearchCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "search <key>\tfinds all values by key and lists them if present\n";
    }
}
