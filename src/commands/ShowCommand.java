package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;


/**
 * Command "show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand extends Command {
    public ShowCommand() {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public String toString() {
        return "show";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
        for (MusicBand element : collection.getCollection()) {
            System.out.println(element.toString());
        }
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
        return null;
    }

}
