package exceptions;


/**
 * Is throwing when Incorrect count of arguments!
 */
public class WrongAmountOfArgumentsException extends Exception {
    public WrongAmountOfArgumentsException() {
        super("Incorrect count of arguments!");
    }
}
