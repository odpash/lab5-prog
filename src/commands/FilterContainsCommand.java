package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;
import java.util.TreeSet;

public class FilterContainsCommand extends Command {
    public FilterContainsCommand() {
        super("filter_contains_name name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    public String toString() {
        return "filter_contains_name";
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
            if (element.getName().contains(param)) {
                System.out.println(element.toString());
            }
        }} catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
        return null;
    }

}
