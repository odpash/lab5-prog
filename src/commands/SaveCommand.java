package commands;

import FileManagment.sources.Csv;
import models.Collection;
import models.MusicBand;

import java.io.IOException;
import java.util.ArrayList;

/**
 "save", "сохранить коллекцию в файл"
 */
public class SaveCommand extends Command {
    public SaveCommand() {
        super("save", "сохранить коллекцию в файл");
    }

    @Override
    public String toString() {
        return "save";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) throws IOException {
        try {
        Csv csv = new Csv(logger, param);
        csv.writeCsvFile(collection);
        return null;
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
    }

}
