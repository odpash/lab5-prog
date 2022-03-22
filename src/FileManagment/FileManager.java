package FileManagment;

import FileManagment.sources.Csv;
import FileManagment.sources.possibleFile;
import exceptions.InvalidFileNameException;
import exceptions.UnsupportedFileExtensionException;
import models.Collection;
import models.MusicBand;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It Check availible fileTypes and start read it
 */
public class FileManager {
    private final String filePath;
    private final String fileExtension;
    private final Logger logger;

    /**
     * Init
     * @param filePath
     * @param logger
     */
    public FileManager(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
        this.fileExtension = fileExtensionRead();
    }

    /**
     * read extensions
     * @return
     */
    private String fileExtensionRead() {
        String fileExtension = "";
        try {
            if (filePath.contains(".")) {
                fileExtension = filePath.split("\\.")[1];
            } else {
                throw new InvalidFileNameException();
            }
        } catch (InvalidFileNameException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.exit(1);
        }
        return fileExtension;
    }

    /**
     * read data from file
     * @return
     * @throws FileNotFoundException
     */
    public Collection readFile() throws FileNotFoundException {
        Csv csv = new Csv(logger, filePath);
        List<possibleFile> possibleFiles = List.of(csv);
        boolean isSupportedFileType = false;
        for (possibleFile file : possibleFiles) {
            if (Objects.equals(file.ToString(), fileExtension)) {
                isSupportedFileType = true;
                return file.read(filePath);

            }
        }
        try {
            if (!isSupportedFileType) {
                throw new UnsupportedFileExtensionException();
            }
        } catch (UnsupportedFileExtensionException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.exit(1);
        }

        return null;
    }


}
