package commands;

import commands.base.*;
import contracts.Command;
import enums.CommandType;
import session.FileSession;

import java.util.HashMap;
import java.util.Map;

public class RegisteredCommands {
    private Map<CommandType, Command> commandsList=new HashMap<>();

    public Map<CommandType, Command> getCommandsList() {
        return commandsList;
    }

    public RegisteredCommands(FileSession session) {
        this.commandsList.put(CommandType.OPEN, new OpenCommand(session));
        this.commandsList.put(CommandType.CLOSE, new CloseCommand(session));
        this.commandsList.put(CommandType.SAVE, new SaveCommand(session));
        this.commandsList.put(CommandType.SAVE_AS, new SaveAsCommand(session));
        this.commandsList.put(CommandType.HELP, new HelpCommand(this,session));
        this.commandsList.put(CommandType.EXIT, new ExitCommand(session));
        this.commandsList.put(CommandType.VALIDATE, new ValidateCommand(session));
        this.commandsList.put(CommandType.PRINT, new PrintCommand(session));
        this.commandsList.put(CommandType.SEARCH, new SearchCommand(session));
        this.commandsList.put(CommandType.SET, new SetCommand(session));
        this.commandsList.put(CommandType.CREATE, new CreateCommand(session));
        this.commandsList.put(CommandType.DELETE, new DeleteCommand(session));
        this.commandsList.put(CommandType.MOVE, new MoveCommand(session));
    }

    public Command getCommand(String commandName){
        return this.commandsList.get(CommandType.fromString(commandName));
    }
}
