package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * "remove_by_id", "удалить элемент из коллекции по его id"
 */
public class RemoveCommand extends Command {
    public RemoveCommand() {
        super("remove_by_id", "удалить элемент из коллекции по его id");
    }

    @Override
    public String toString() {
        return "remove_by_id";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
        TreeSet<MusicBand> treeSet = collection.getCollection();
        TreeSet<MusicBand> newTreeSet = new TreeSet<>();
        for (MusicBand element : treeSet) {
            if (!(element.getId() == Long.parseLong(param))) {
                newTreeSet.add(element);
            }
        }
        collection.setCollection(newTreeSet);
        return null;
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
    }

}
