package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * "filter_starts_with_name name", "вывести элементы, значение поля name которых начинается с заданной подстроки"
 */
public class FilterStartsCommand extends Command {
    public FilterStartsCommand() {
        super("filter_starts_with_name name", "вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public String toString() {
        return "filter_starts_with_name";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
        TreeSet<MusicBand> treeSet = collection.getCollection();
        for (MusicBand element : treeSet) {
            if (element.getName().startsWith(param)) {
                System.out.println(element.toString());
            }
        }
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
        return null;
    }

}
