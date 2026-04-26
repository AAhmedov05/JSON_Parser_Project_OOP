package session;

import contracts.JsonValue;

import java.io.*;

public class FileSession {
    private String filePath;
    private JsonValue jsonRoot;
    private String content;
    private boolean isOpen;

    public String getFilePath() {
        return filePath;
    }

    public JsonValue getJsonRoot() {
        return jsonRoot;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void openFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
            content = "";
        } else {
            content = readFromFile(file);
        }

        this.filePath = path;
        this.isOpen = true;
    }

    public void closeFile(){
        this.filePath=null;
        this.jsonRoot=null;
        this.isOpen=false;
    }

    private String readFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        reader.close();
        return sb.toString();
    }
}
