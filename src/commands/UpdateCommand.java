package commands;

import models.Collection;
import models.MusicBand;
import utils.Console;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Command "update id {element}" - "обновить значение элемента коллекции, id которого равен заданному"
 */
public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public String toString() {
        return "update";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
        TreeSet<MusicBand> treeSet = collection.getCollection();
        if (musicBand.getName().equals("")) {
            musicBand = Console.elementInterator();
        }
        TreeSet<MusicBand> newTreeSet = new TreeSet<>();
        for (MusicBand element : treeSet) {
            if (element.getId() == Long.parseLong(param)) {
                musicBand.setId(element.getId());
                newTreeSet.add(musicBand);
            } else {
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
