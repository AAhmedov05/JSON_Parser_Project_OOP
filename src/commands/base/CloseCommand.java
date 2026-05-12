package commands.base;

import contracts.Command;
import core.JsonService;
import session.FileSession;

public class CloseCommand extends Command {
    public CloseCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        if (!getJsonService().getSession().isOpen())
            return "No file is currently open.";
        if (params.length > 1)
            return this.getDescription();
        String fileName= getJsonService().getSession().getFilePath();
        getJsonService().getSession().closeFile();
        return "Successfully closed "+fileName;
    }

    @Override
    public String getDescription() {
        return "close\tcloses currently opened file\n";
    }
}
