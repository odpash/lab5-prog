package commands;

import models.Collection;
import models.MusicBand;

import java.util.ArrayList;


/**
 * "help", "вывести справку по доступным командам"
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public String toString() {
        return "help";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) {
        try {
            for (Command cmd : Command.activeCommands()) {
                System.out.println(cmd.help());
            }
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
        return true;
    }

}
