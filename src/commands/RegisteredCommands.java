package commands;

import commands.base.*;
import contracts.Command;
import core.JsonService;
import enums.CommandType;
import session.FileSession;

import java.util.HashMap;
import java.util.Map;

public class RegisteredCommands {
    private Map<CommandType, Command> commandsList=new HashMap<>();

    public Map<CommandType, Command> getCommandsList() {
        return commandsList;
    }

    public RegisteredCommands(JsonService service) {
        this.commandsList.put(CommandType.OPEN, new OpenCommand(service));
        this.commandsList.put(CommandType.CLOSE, new CloseCommand(service));
        this.commandsList.put(CommandType.SAVE, new SaveCommand(service));
        this.commandsList.put(CommandType.SAVE_AS, new SaveAsCommand(service));
        this.commandsList.put(CommandType.HELP, new HelpCommand(this,service));
        this.commandsList.put(CommandType.EXIT, new ExitCommand(service));
        this.commandsList.put(CommandType.VALIDATE, new ValidateCommand(service));
        this.commandsList.put(CommandType.PRINT, new PrintCommand(service));
        this.commandsList.put(CommandType.SEARCH, new SearchCommand(service));
        this.commandsList.put(CommandType.SET, new SetCommand(service));
        this.commandsList.put(CommandType.CREATE, new CreateCommand(service));
        this.commandsList.put(CommandType.DELETE, new DeleteCommand(service));
        this.commandsList.put(CommandType.MOVE, new MoveCommand(service));
    }

    public Command getCommand(String commandName){
        return this.commandsList.get(CommandType.fromString(commandName));
    }
}
