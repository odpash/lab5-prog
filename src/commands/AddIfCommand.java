package commands;

import models.Collection;
import models.MusicBand;
import utils.Console;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Command "add_if_max {element}" - "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"
 */
public class AddIfCommand extends Command {
    public AddIfCommand() {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }

    @Override
    public String toString() {
        return "add_if_max";
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
            if (musicBand.compareTo(currentCollection.last()) > 0) {
                currentCollection.add(musicBand);
            } else {
                musicBand.setId(musicBand.getId() - 1);
            }
            collection.setCollection(currentCollection);
            return null;
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
    }


}
