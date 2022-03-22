import FileManagment.FileManager;
import models.Collection;
import models.MusicBand;
import utils.Console;

import java.io.FileInputStream;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.LogManager;


/**
 * Main application class. Creates all instances and runs the program.
 */
public class Main {
    static java.util.logging.Logger LOGGER;
    static {  // Logger init
        try (FileInputStream ins = new FileInputStream(new java.io.File("").getAbsolutePath() + "/log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = java.util.logging.Logger.getLogger(Main.class.getName());
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            LOGGER.log(Level.INFO, "Script started. Variant: 3114013");
            var filePath = parseArgs(args);
            FileManager fileManager = new FileManager(filePath, LOGGER);
            Collection collection = fileManager.readFile();
            Console console = new Console(collection, LOGGER, filePath);
            console.interactiveMode();
        }
        catch (Exception e) {
            LOGGER.log(Level.WARNING, "Unexpected error.", e);
        }
        }

    private static String parseArgs(String[] args) {
        String filePath = "/Users/olegpash/IdeaProjects/lab5-prog/collection.csv";
        //try {
        //    if (args.length == 1) {  // change to args
        //        filePath = args[0];
        //    }
        //    else {
        //        throw new InvalidParamsCount();
        //    }
        //} catch (InvalidParamsCount e) {
        //    LOGGER.log(Level.WARNING, e.getMessage());
        //    System.exit(1);
        //}
        return filePath;
    }
}