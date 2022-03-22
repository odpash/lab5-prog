package commands;

import FileManagment.Validator;
import models.Collection;
import models.MusicBand;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * "execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."
 */
public class ExecuteCommand extends Command{
    public ExecuteCommand() {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public String toString() {
        return "execute_script";
    }


    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public Boolean run(String param, ArrayList<String> argument2, Collection collection, MusicBand musicBand) throws IOException {
        try {
        File file = new File(param); // /Users/olegpash/IdeaProjects/lab5-prog/src/script.txt
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String executeCommand = null;
        int index = -1;
        boolean fl = false;
        String[] userInput = {"", "Test name", "", "", "", "", "POP", "", "", "Test album", "", ""};

        while((line = br.readLine()) != null){
            //process the line
            index++;
            List<Command> listOfCommands = Command.activeCommands();
            if (fl) {
                userInput[index] = line;
                if (index == 11) {
                    fl = false;
                    if (Validator.validate(userInput, logger)) {
                        for (Command command : listOfCommands) {
                            if (command.toString().equals(executeCommand)) {
                                System.out.println(command.toString());
                                command.run(executeCommand, argument2, collection, new MusicBand(userInput));
                            }
                        }
                    }
                    continue;
                }

            }
            String[] userCommand = (line.trim() + " ").split(" ", 2);
            if (userCommand.length > 0) {
                userCommand[1] = userCommand[1].trim();
            }

            boolean hasFoundedCommand = false;
            for (Command command : listOfCommands) {
                if (command.toString().equals(userCommand[0])) {
                    if (userCommand[0].contains("add") || userCommand[0].contains("update") || userCommand[0].contains("add_if_max") || userCommand[0].contains("remove_greater")) {
                        executeCommand = userCommand[0];
                        index = -1;
                        fl = true;
                        break;
                    }
                    argument2.add(userCommand[0]);
                    hasFoundedCommand = true;
                    command.run(userCommand[1], argument2, collection, new MusicBand(userInput));
                }
            }
            if (!hasFoundedCommand && !fl) {
                System.out.println("Command not found!");
            }
        }

        return null;
        } catch (Exception e) {
            System.out.println("Failed to execute " + toString());
            return false;
        }
    }

}
