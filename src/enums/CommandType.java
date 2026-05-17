package enums;

import exceptions.InvalidCommandException;

/**
 * Represents all supported command types in the system.
 */
public enum CommandType {
    OPEN,
    CLOSE,
    SAVE,
    SAVE_AS,
    HELP,
    EXIT,
    VALIDATE,
    PRINT,
    SEARCH,
    SET,
    CREATE,
    DELETE,
    MOVE;

    /**
     * Converts a string into a CommandType.
     * @param input the command name as text
     * @return the matching CommandType
     * @throws InvalidCommandException if the command is unknown
     */
    public static CommandType fromString(String input) throws Exception {
        return switch (input.toLowerCase()) {
            case "open" -> OPEN;
            case "close" -> CLOSE;
            case "save" -> SAVE;
            case "saveas" -> SAVE_AS;
            case "help" -> HELP;
            case "exit" -> EXIT;
            case "validate" -> VALIDATE;
            case "print" -> PRINT;
            case "search" -> SEARCH;
            case "set" -> SET;
            case "create" -> CREATE;
            case "delete" -> DELETE;
            case "move" -> MOVE;
            default -> throw new InvalidCommandException("Unknown Command " + input + ". Type 'help' for a list of available commands.");
        };
    }
}