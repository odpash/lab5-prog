package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;


/**
 * "exit", "завершить программу (без сохранения в файл)"
 */
public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public String toString() {
        return "exit";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        System.exit(0);
        return null;
    }

}
