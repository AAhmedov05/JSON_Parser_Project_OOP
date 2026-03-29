package contracts;

public interface Command {
    String execute(String params);
    String getDescription();
}
