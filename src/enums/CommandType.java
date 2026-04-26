package enums;

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

    public static CommandType fromString(String input) {
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
            default -> null;
        };
    }
}