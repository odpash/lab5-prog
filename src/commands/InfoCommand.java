package commands;

public class InfoCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public InfoCommand() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public String toString() {
        return "info";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
