import contracts.Command;
import commands.RegisteredCommands;
import session.FileSession;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FileSession session=new FileSession();
        RegisteredCommands registeredCommand=new RegisteredCommands(session);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type help to see all commands!");
        while (true) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");
            String commandName = parts[0];
            Command command = registeredCommand.getCommand(commandName);

            if (command == null) {
                System.out.println("Unknown command");
                continue;
            }
            try {
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
