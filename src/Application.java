import contracts.Command;
import commands.RegisteredCommands;

public class Application {
    public static void main(String[] args) {

        RegisteredCommands registeredCommand=new RegisteredCommands();
        Command command =registeredCommand.getCommand("help");
        String filePath="example.json";
        System.out.println(command.execute(filePath));

    }
}
