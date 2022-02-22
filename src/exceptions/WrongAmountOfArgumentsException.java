package exceptions;

public class WrongAmountOfArgumentsException extends Exception {
    public WrongAmountOfArgumentsException() {
        super("Incorrect count of arguments!");
    }
}
