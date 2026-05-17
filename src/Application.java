import contracts.Command;
import commands.RegisteredCommands;
import core.JsonService;
import session.FileSession;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FileSession session=new FileSession();
        JsonService service=new JsonService(session);
        RegisteredCommands registeredCommand=new RegisteredCommands(service);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type help to see all commands!");
        while (true) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String commandName = parts[0];
            try {
                Command command = registeredCommand.getCommand(commandName);
                String result = command.execute(parts);
                if (result != null)
                    System.out.println(result);
                if (commandName.equals("exit"))
                    break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
