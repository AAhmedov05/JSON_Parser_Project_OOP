package commands;

import contracts.Command;
import session.FileSession;

public class SearchCommand extends Command {
    public SearchCommand(FileSession session) {
        super(session);
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
