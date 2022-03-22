package commands;


import models.Collection;
import models.MusicBand;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Command ""clear" - "очистить коллекцию""
 */
public class ClearCommand extends Command {
    public ClearCommand() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public String toString() {
        return "clear";
    }

    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            TreeSet<MusicBand> newTreeSet = new TreeSet<>();
            collection.setCollection(newTreeSet);
            return null;
        }  catch (Exception e) {
        System.out.println("Failed to execute " + toString());
        return false;
    }
    }
}
