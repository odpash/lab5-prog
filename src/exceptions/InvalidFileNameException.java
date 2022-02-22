package exceptions;

public class InvalidFileNameException extends Exception {
    public InvalidFileNameException() {
        super("The filename must contain a dot in it's name!");
    }
}
