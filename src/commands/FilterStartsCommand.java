package commands;

public class FilterStartsCommand extends Command {
    @Override
    public int argumentsCount() {
        return 1;
    }

    public FilterStartsCommand() {
        super("filter_starts_with_name name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public String toString() {
        return "filter_starts_with_name";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
