package commands;

public class HelpCommand implements Command {
    @Override
    public void execute(String params) {
        System.out.println("The following commands are supported: ");
        System.out.println("open <file> opens <file>");
        System.out.println("close \tcloses currently opened file");
        System.out.println("save \tsaves the currently open file");
        System.out.println("save as <file> \tsaves the currently open file in <file>");
        System.out.println("help \tprints this information");
        System.out.println("exit \texists the program");
        System.out.println("validate");
        System.out.println("print");
        System.out.println("search <key>");
        System.out.println("set <path> <string>");
        System.out.println("create <path> <string>");
        System.out.println("delete <path>");
        System.out.println("move <from> <to>");
        System.out.println("save <path>");
        System.out.println("save as <file> <path>");
    }
}
