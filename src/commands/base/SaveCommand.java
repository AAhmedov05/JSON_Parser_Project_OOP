package commands.base;

import contracts.Command;
import core.JsonService;

import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand(JsonService service) {
        super(service);
    }

    @Override
    public String execute(String[] params) {
        getJsonService().isJsonOpen();
        try {
                if (params.length<2)
                    getJsonService().getSession().save();
                else if(params.length<3)
                    getJsonService().getSession().saveAs(params[1]);
                else
                    return  this.getDescription();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return "Successfully saved "+params[1];
    }

    @Override
    public String getDescription() {
        return "save\tsaves the currently open file\nsave [<path>]\tsaves current object or object at <path>\n";
    }
}
