package contracts;

import session.FileSession;

public abstract class Command {
    protected FileSession session;

    public Command(FileSession session) {
        this.session = session;
    }

    public abstract String execute(String[] params);
    public abstract String getDescription();
}
