package commands;

public class ShowCommand extends Command {
    @Override
    public int argumentsCount() {
        return 0;
    }

    public ShowCommand() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public String toString() {
        return "show";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
