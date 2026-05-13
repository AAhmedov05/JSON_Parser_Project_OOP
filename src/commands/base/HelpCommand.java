package commands.base;

import commands.RegisteredCommands;
import contracts.Command;
import core.JsonService;
import session.FileSession;

/**
 * Command that shows all available commands.
 * <p>
 * It prints the descriptions of all registered commands.
 */
public class HelpCommand extends Command {

    private RegisteredCommands registeredCommands;

    /**
     * Creates a HelpCommand with the given command registry and JSON service.
     * @param registeredCommands the registry of all commands
     * @param service the JSON service used by the command
     */
    public HelpCommand(RegisteredCommands registeredCommands, JsonService service) {
        super(service);
        this.registeredCommands = registeredCommands;
    }

    /**
     * Executes the help command.
     * <p>
     * It collects all command descriptions and returns them.
     * @param params command arguments; no parameters are needed
     * @return all command descriptions
     */
    @Override
    public String execute(String[] params) {
        StringBuilder sb=new StringBuilder();
        for (Command command : this.registeredCommands.getCommandsList().values()) {
            sb.append(command.getDescription());
        }
        return sb.toString();
    }

    /**
     * Returns the command description.
     * @return help command usage text
     */
    @Override
    public String getDescription() {
        return "help\tprints this information\n";
    }
}