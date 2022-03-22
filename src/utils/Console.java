package utils;

import FileManagment.Validator;
import models.Collection;
import models.MusicBand;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Interactive mode start file
 */
public class Console {
    private final Collection collection;
    private static Logger logger;
    private String filePath;

    /**
     * initizialize
     * @param collection
     * @param logger
     * @param filePath
     */
    public Console(Collection collection, Logger logger, String filePath) {
        this.collection = collection;
        Console.logger = logger;
        this.filePath = filePath;
    }

    /**
     * Read command
     */
    public void interactiveMode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        Scanner scanner = new Scanner(System.in);
        commandManager cmdMng = new commandManager();
        try {
            do {
                System.out.print("--> ");
                ;
                userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                if (userCommand[0].equals("save")) {
                    userCommand[1] = filePath;
                }
                commandStatus = cmdMng.launchCommand(userCommand, collection);
                } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            System.out.println("Пользовательский ввод не обнаружен!");
        } catch (IllegalStateException exception) {
            System.out.println("Непредвиденная ошибка!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Input element from user
     * @return
     */
    public static MusicBand elementInterator() {
        String[] paramsToInput = {"", "имя", "", "число участников", "Описание", "Дата создания группы", "Жанр", "Расположение по X", "Расположение по Y", "Название лучшего альбома", "Треки", "Длина"};
        String[] userInput = {"", "Test name", "", "", "", "", "POP", "", "", "Test album", "", ""};
        Scanner sc = new Scanner(System.in);
        int index = 0;
        for (String param : paramsToInput) {
            while (true) {
                if (!param.equals("")) {
                    System.out.println("");
                    System.out.printf("Введите параметр `%s`: ", param);
                    userInput[index] = sc.nextLine();
                    boolean isInputCorrect = Validator.validate(userInput, logger);
                    if (isInputCorrect) {
                        break;
                    }
                } else {
                    break;
                }
            }
            index++;
        }
        System.out.println();
        return new MusicBand(userInput);
    }

}