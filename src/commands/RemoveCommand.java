package commands;

public class RemoveCommand extends Command {
    @Override
    public int argumentsCount() {
        return 1;
    }

    public RemoveCommand() {
        super("remove_by_id id", "удалить элемент из коллекции по его id");
    }

    @Override
    public String toString() {
        return "remove_by_id id";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
