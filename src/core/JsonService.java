package core;

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
}
