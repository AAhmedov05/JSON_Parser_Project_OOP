package commands;

import contracts.Command;

public class SearchCommand implements Command {
    @Override
    public String execute(String params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "search <key>\tfinds all values by key and lists them if present\n";
    }
}
