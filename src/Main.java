import FileManagment.FileManager;
import exceptions.InvalidParamsCount;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {
    static java.util.logging.Logger LOGGER;
    static {
        try (FileInputStream ins = new FileInputStream(new java.io.File("").getAbsolutePath() + "/log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = java.util.logging.Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            LOGGER.log(Level.INFO, "Script started. Variant: 3114013");
            /*
            String filePath = "";
            try {
                if (args.length == 1) {  // change to args
                    filePath = args[0];
                }
                else {
                    throw new InvalidParamsCount();
                }
            } catch (InvalidParamsCount e) {
                LOGGER.log(Level.WARNING, e.getMessage());
                System.exit(1);
            }

             */
            InteractiveMode interactiveMode = new InteractiveMode();
            interactiveMode.run();
            System.exit(1);
            String filePath = "/Users/olegpash/IdeaProjects/lab5-prog/collection.csv";

            FileManager fileManager = new FileManager(filePath, LOGGER);
            fileManager.readFile();
        }
        catch (Exception e) {
            LOGGER.log(Level.WARNING, "Unexpected error.", e);
        }
        }
}