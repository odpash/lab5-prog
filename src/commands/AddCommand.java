package commands;

import models.Collection;
import models.MusicBand;
import utils.Console;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Command "add {element}" - "добавить новый элемент в коллекцию"
 */
public class AddCommand extends Command {
    public AddCommand() {
        super("add {element}", "добавить новый элемент в коллекцию");
    }

    @Override
    public String toString() {
        return "add";
    }

    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            TreeSet<MusicBand> currentCollection = collection.getCollection();
            if (musicBand.getName().equals("")) {
                musicBand = Console.elementInterator();
            }
            currentCollection.add(musicBand);
            collection.setCollection(currentCollection);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }

    }

}
