package commands;

public class RemoveGreaterCommand extends Command {
    @Override
    public int argumentsCount() {
        return 1;
    }

    public RemoveGreaterCommand() {
        super("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public String toString() {
        return "remove_greater";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
