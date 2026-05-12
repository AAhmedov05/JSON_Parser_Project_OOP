package contracts;

import core.JsonService;

public abstract class Command {
    private JsonService jsonService;

    public JsonService getJsonService() {
        return jsonService;
    }

    public Command(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    public abstract String execute(String[] params);
    public abstract String getDescription();
}
