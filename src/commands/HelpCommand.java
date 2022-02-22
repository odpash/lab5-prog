package commands;

public class HelpCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public String toString() {
        return "help";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
