package commands;

import models.Collection;
import models.MusicBand;
import utils.Console;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * "remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный"
 */
public class RemoveGreaterCommand extends Command {
    public RemoveGreaterCommand() {
        super("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public String toString() {
        return "remove_greater";
    }


    /**
     * Executes the command.
     *
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            TreeSet<MusicBand> currentCollection = collection.getCollection();
            if (musicBand.getName().equals("")) {
                musicBand = Console.elementInterator();
            }
            TreeSet<MusicBand> newTreeSet = new TreeSet<>();
            for (MusicBand element : currentCollection) {
                if ((musicBand.compareTo(element) >= 0)) {
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
