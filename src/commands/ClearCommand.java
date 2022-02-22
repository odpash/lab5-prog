package commands;

public class ClearCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public ClearCommand() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String toString() {
        return "clear";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }
}
