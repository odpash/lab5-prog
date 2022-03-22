package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * "count_by_genre genre", "вывести количество элементов, значение поля genre которых равно заданному"
 */
public class CountByGenreCommand extends Command{
    public CountByGenreCommand() {
        super("count_by_genre genre", "вывести количество элементов, значение поля genre которых равно заданному");
    }

    @Override
    public String toString() {
        return "count_by_genre";
    }

    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            TreeSet<MusicBand> treeSet = collection.getCollection();
            int count = 0;
            for (MusicBand element : treeSet) {
                if (element.getGenre().equals(param)) {
                    count++;
                }
            }
            System.out.println(count);
            return null;
        } catch (Exception e) {
        System.out.println("Failed to execute " + toString());
        return false;
    }
    }

}
