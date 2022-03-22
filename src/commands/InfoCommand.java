package commands;
import models.Collection;
import models.MusicBand;

import java.util.ArrayList;

/**
 * "info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"
 */

public class InfoCommand extends Command {
    public InfoCommand() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public String toString() {
        return "info";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            System.out.println(collection.information());
        } catch (Exception e) {
        System.out.println("Failed to execute " + toString());
        return false;
    }
        return true;
    }
}
