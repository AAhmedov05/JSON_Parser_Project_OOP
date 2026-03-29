package commands;

import contracts.Command;
import enums.CommandType;

import java.util.HashMap;
import java.util.Map;

public class RegisteredCommands {
    private Map<CommandType, Command> commandsList=new HashMap<>();;

    public Map<CommandType, Command> getCommandsList() {
        return commandsList;
    }

    public RegisteredCommands() {
        this.commandsList.put(CommandType.OPEN, new OpenCommand());
        this.commandsList.put(CommandType.CLOSE, new CloseCommand());
        this.commandsList.put(CommandType.SAVE, new SaveCommand());
        this.commandsList.put(CommandType.SAVE_AS, new SaveAsCommand());
        this.commandsList.put(CommandType.HELP, new HelpCommand(this));
        this.commandsList.put(CommandType.EXIT, new ExitCommand());
        this.commandsList.put(CommandType.VALIDATE, new ValidateCommand());
        this.commandsList.put(CommandType.PRINT, new PrintCommand());
        this.commandsList.put(CommandType.SEARCH, new SearchCommand());
        this.commandsList.put(CommandType.SET, new SetCommand());
        this.commandsList.put(CommandType.CREATE, new CreateCommand());
        this.commandsList.put(CommandType.DELETE, new DeleteCommand());
        this.commandsList.put(CommandType.MOVE, new MoveCommand());
    }

    public Command getCommand(String commandName){
        return this.commandsList.get(CommandType.fromString(commandName));
    }
}
