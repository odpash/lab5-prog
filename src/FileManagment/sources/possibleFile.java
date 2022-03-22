package FileManagment.sources;

import models.Collection;
import models.MusicBand;

import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * abstract class of files
 */
public abstract class possibleFile {
    public Logger logger;
    public String filePath;
    public possibleFile(Logger logger, String filePath) {
        this.filePath = filePath;
        this.logger = logger;
    }
    public abstract Collection read(String filePath) throws FileNotFoundException;
    public abstract String ToString();
}
