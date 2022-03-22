package exceptions;


/**
 * Is throwing when no access to file!
 */
public class NoAccessToFileException extends Exception {
    public NoAccessToFileException() {
        super("No access to file!");
    }
}
