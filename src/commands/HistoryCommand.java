package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;


/**
 * "history", "вывести последние 14 команд (без их аргументов)"
 */
public class HistoryCommand extends Command {
    public HistoryCommand() {
        super("history", "вывести последние 14 команд (без их аргументов)");
    }

    @Override
    public String toString() {
        return "history";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
        int startIdx = argument2.size() - 15;
        if (startIdx < 0) { startIdx = 0; }
        for(int i = startIdx; i < argument2.size(); i++) {
            String value = argument2.get(i);
            System.out.println(value);
        }
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }

        return null;
    }

}
