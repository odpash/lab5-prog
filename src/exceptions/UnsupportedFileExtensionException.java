package exceptions;


/**
 * Is throwing when file type is not supported yet!
 */
public class UnsupportedFileExtensionException extends Exception {
    public UnsupportedFileExtensionException() {
        super("This file type is not supported yet!");
    }
}
