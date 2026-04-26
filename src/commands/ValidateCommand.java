package commands;

import contracts.Command;
import session.FileSession;

public class ValidateCommand extends Command {
    public ValidateCommand(FileSession session) {
        super(session);
    }

    @Override
    public String execute(String[] params) {
        return "";
    }

    @Override
    public String getDescription() {
        return "validate\tchecks if file is valid JSON and reports detailed errors\n";
    }
}
