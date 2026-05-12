package commands.base;

import commands.RegisteredCommands;
import contracts.Command;
import core.JsonService;
import session.FileSession;

public class HelpCommand extends Command {
    private RegisteredCommands registeredCommands;

    public HelpCommand(RegisteredCommands registeredCommands, JsonService service) {
        super(service);
        this.registeredCommands = registeredCommands;
    }

    @Override
    public String execute(String[] params) {
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
