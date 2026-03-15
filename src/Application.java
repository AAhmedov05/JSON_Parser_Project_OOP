import commands.Command;
import commands.RegisteredCommands;

public class Application {
    public static void main(String[] args) {
        RegisteredCommands registeredCommand=new RegisteredCommands();
        Command command =registeredCommand.getCommand("help");
        String filePath="example.json";
        command.execute(filePath);

    }
}
