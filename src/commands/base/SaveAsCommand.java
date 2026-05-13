package commands.base;

import contracts.Command;
import core.JsonService;

import java.io.IOException;

public class SaveAsCommand extends Command {
    public SaveAsCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        getJsonService().isJsonOpen();
        try {
            if (params.length==2)
                getJsonService().getSession().saveAs(params[1]);
            else if(params.length==3)
                getJsonService().getSession().saveAs(params[1],params[2]);
            else
                return  this.getDescription();
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Successfully saved "+params[1];
    }

    @Override
    public String getDescription() {
        return "save as <file>\tsaves the currently open file in <file>\nsave as <file> [<path>]\tsaves object to <file>\n";
    }
}
