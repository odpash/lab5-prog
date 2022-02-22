package exceptions;

public class InvalidParamsCount extends Exception {
    public InvalidParamsCount() {
        super("File parameter was not passed / too many parameters were passed.");
    }
}
