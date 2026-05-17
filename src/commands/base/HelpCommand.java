package commands.base;

import commands.RegisteredCommands;
import contracts.Command;
import exceptions.InvalidCommandException;

/**
 * Command that shows all available commands.
 * <p>
 * It prints the descriptions of all registered commands.
 */
public class HelpCommand implements Command {

    private RegisteredCommands registeredCommands;

    /**
     * Creates a HelpCommand with the given command registry 
     * @param registeredCommands the registry of all commands
     */
    public HelpCommand(RegisteredCommands registeredCommands) {
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
        if (params.length != 1)
            throw new InvalidCommandException(this.getDescription());

        StringBuilder sb = new StringBuilder();
        for (Command command : registeredCommands.getCommandsList().values()) {
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