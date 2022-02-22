package commands;

public class CountByGenreCommand extends Command{
    @Override
    public int argumentsCount() {
        return 1;
    }

    public CountByGenreCommand() {
        super("count_by_genre genre", "вывести количество элементов, значение поля genre которых равно заданному");
    }

    @Override
    public String toString() {
        return "count_by_genre";
    }

    @Override
    public Boolean run(String param) {
        return null;
    }

}
