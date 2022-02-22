package commands;

public class UpdateCommand extends Command {
    @Override
    public int argumentsCount() {
        return 2;
    }

    public UpdateCommand() {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public String toString() {
        return "update";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
