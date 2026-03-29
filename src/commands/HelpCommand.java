package commands;

import contracts.Command;
import enums.CommandType;

import java.util.Map;

public class HelpCommand implements Command {
    private RegisteredCommands registeredCommands;

    public HelpCommand(RegisteredCommands registeredCommands) {
        this.registeredCommands = registeredCommands;
    }

    @Override
    public String execute(String params) {
        StringBuilder sb=new StringBuilder();
        for (Command command:this.registeredCommands.getCommandsList().values()){
            sb.append(command.getDescription());
        }
        return sb.toString();
    }
    @Override
    public String getDescription() {
        return "help\tprints this information\n";
    }
}
