package exceptions;


/**
 * Is throwing when File parameter was not passed / too many parameters were passed.
 */
public class InvalidParamsCount extends Exception {
    public InvalidParamsCount() {
        super("File parameter was not passed / too many parameters were passed.");
    }
}
