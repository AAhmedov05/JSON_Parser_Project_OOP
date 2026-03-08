public class Application {
    public static void main(String[] args) {
        Command openCommand=new OpenCommand();
        String filePath="example.json";
        openCommand.execute(new String[]{filePath});
    }
}
