package session;

import contracts.JsonValue;

public class FileSession {
    private String filePath;
    private JsonValue jsonRoot;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public JsonValue getJsonRoot() {
        return jsonRoot;
    }

    public void setJsonRoot(JsonValue jsonRoot) {
        this.jsonRoot = jsonRoot;
    }

    public boolean isOpen(){
        return this.filePath!=null;
    }

    public void closeFile(){
        this.filePath=null;
        this.jsonRoot=null;
    }
}
