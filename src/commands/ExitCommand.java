package commands;

public class ExitCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public String toString() {
        return "exit";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
