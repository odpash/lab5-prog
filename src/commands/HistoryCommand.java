package commands;

public class HistoryCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public HistoryCommand() {
        super("history", "вывести последние 14 команд (без их аргументов)");
    }

    @Override
    public String toString() {
        return "history";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
