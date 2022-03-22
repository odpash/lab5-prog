package FileManagment;

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Validator data file
 */
public class Validator {
    /**
     * validates data with throwing exceptions to logger
     * @param data
     * @param logger
     * @return
     */
    public static boolean validate(String[] data, Logger logger) {
        if (logger == null) {
                try (FileInputStream ins = new FileInputStream(new java.io.File("").getAbsolutePath() + "/log.config")) {
                    LogManager.getLogManager().readConfiguration(ins);
                    logger = java.util.logging.Logger.getLogger(Main.class.getName());
                } catch (Exception err) {
                    err.printStackTrace();
                }
        }
        int index = 0;
        for (String element : data) {
            if (index == 1 && element.length() == 0) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `имя` не должно быть пустым!");
                return false;
            } else if (index == 3 && (element.matches("-\\d+") || (!element.matches("\\d+") && element.equals("0")))) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `число участников` должно быть целым числом большим нуля!");
                return false;
            } else if (index == 5 && (element.length() > 0 && !(element.charAt(4) == '-' && element.charAt(7) == '-' &&
                    element.substring(0, 4).matches("\\d+") && element.substring(6, 7).matches("\\d+") &&
                    element.substring(9, 10).matches("\\d+")))) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `дата создания группы` должно быть в формате yyyy-mm-dd!");
                return false;
            } else if (index == 6 && !(element.equals("PSYCHEDELIC_CLOUD_RAP") || element.equals("POP") || element.equals("POST_PUNK"))) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `Жанр` должно быть одним из данного перечня: PSYCHEDELIC_CLOUD_RAP, POST_PUNK, POP!");
                return false;
            } else if (index == 7 && (element.length() != 0 && !element.matches("\\d+"))) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `Расположение по X` должно быть целым числом!");
                return false;
            } else if (index == 8 && element.length() != 0 && (!element.matches("\\d+") || Long.parseLong(element) > 719)) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `Расположение по Y` должно быть целым числом, а также быть меньше 720!");
                return false;
            } else if (index == 9 && element.length() == 0) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоле `Название лучшего альбома` должно быть не пустым!");
                return false;
            } else if ((index == 10 || index == 11) && (element.matches("[-+]?\\d+") && Integer.parseInt(element) < 1)) {
                logger.log(Level.WARNING, "Ошибка парсинга!\nПоля `Треки` и `Длина` должны быть не пустыми и целыми положительными числами!");
                return false;
            }
            index++;
        }
        return true;
    }
}
