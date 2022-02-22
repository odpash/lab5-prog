package exceptions;

public class NoAccessToFileException extends Exception {
    public NoAccessToFileException() {
        super("No access to file!");
    }
}
