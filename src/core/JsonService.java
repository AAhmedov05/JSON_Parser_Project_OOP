package core;

import exceptions.FileException;
import json.*;
import session.FileSession;

public class JsonService {
    private FileSession session;

    public JsonService(FileSession session) {
        this.session = session;
    }

    public FileSession getSession() {
        return session;
    }

    public String print(){
        return session.getJsonRoot().toJson(0);
    }

    public void isJsonOpen(){
        if (!session.isOpen())
            throw new FileException("No file is currently open");
    }
}
