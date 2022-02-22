package FileManagment.sources;

import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class possibleFile {
    public Logger logger;
    public possibleFile(Logger logger) {
        this.logger = logger;
    }
    public abstract TreeSet<Object> read(String filePath) throws FileNotFoundException;
    public abstract String ToString();
}
