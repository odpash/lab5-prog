package utils;

import commands.Command;
import models.Collection;
import models.MusicBand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command execution dispatcher
 */
public class commandManager {
    private ArrayList<String> arrayList = new ArrayList<>();

    /**
     * Chosing command from command list
     * @param userInput
     * @param collection
     * @return
     * @throws IOException
     */
    public int launchCommand(String[] userInput, Collection collection) throws IOException {
        String argument1 = "";
        String userCommand = userInput[0];
        arrayList.add(userCommand);
        if (userInput.length > 1) {
            argument1 = userInput[1];
        }
        List<Command> listOfCommands = Command.activeCommands();
             for (Command command : listOfCommands) {
                 if (command.toString().equals(userCommand)) {
                     command.run(argument1, arrayList, collection, new MusicBand());
                     return 0;
                 }
             }
        System.out.println("Command not found!");
        return 0;
    }
}
