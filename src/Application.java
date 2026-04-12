import contracts.Command;
import commands.RegisteredCommands;
import session.FileSession;

public class Application {
    public static void main(String[] args) {
        FileSession session=new FileSession();
        RegisteredCommands registeredCommand=new RegisteredCommands(session);
        Command command =registeredCommand.getCommand("help");
        String filePath="example.json";
        System.out.println(command.execute(filePath));

    }
}
