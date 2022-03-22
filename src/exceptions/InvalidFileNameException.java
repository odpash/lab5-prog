package exceptions;


/**
 * Is throwing when FileName is Invalid
 */
public class InvalidFileNameException extends Exception {
    public InvalidFileNameException() {
        super("The filename must contain a dot in it's name!");
    }
}
