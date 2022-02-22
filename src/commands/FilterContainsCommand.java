package commands;

public class FilterContainsCommand extends Command {
    @Override
    public int argumentsCount() {
        return 1;
    }

    public FilterContainsCommand() {
        super("filter_contains_name name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    public String toString() {
        return "filter_contains_name";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
