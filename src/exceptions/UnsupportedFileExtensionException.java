package exceptions;

public class UnsupportedFileExtensionException extends Exception {
    public UnsupportedFileExtensionException() {
        super("This file type is not supported yet!");
    }
}
