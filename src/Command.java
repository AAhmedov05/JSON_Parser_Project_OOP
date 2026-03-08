public abstract class Command {
    private String commandName;

    public String getCommandName() {
        return commandName;
    }

    public Command(String commandName) {
        this.commandName = commandName;
    }

    public abstract void execute(String[] params);
}
