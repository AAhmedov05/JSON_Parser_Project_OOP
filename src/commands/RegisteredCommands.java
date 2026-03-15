package commands;

import java.util.HashMap;
import java.util.Map;

public class RegisteredCommands {
    private Map<String,Command> commandsList=new HashMap<>();

    public RegisteredCommands() {
        this.commandsList.put("open", new OpenCommand());
        this.commandsList.put("help", new HelpCommand());
    }

    public Command getCommand(String commandName){
        return this.commandsList.get(commandName);
    }
}
