import java.io.*;
import java.util.*;

public class OpenCommand extends Command{
    public OpenCommand() {
        super("Open");
    }

    @Override
    public void execute(String[] params) {
        String filePath=params[0];
        File file=new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileValidation.fileOpened(file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
