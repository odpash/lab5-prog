package FileManagment;

import FileManagment.sources.Csv;
import FileManagment.sources.possibleFile;
import exceptions.InvalidFileNameException;
import exceptions.UnsupportedFileExtensionException;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {
    private String filePath;
    private String fileExtension;
    private Logger logger;

    public FileManager(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
        this.fileExtension = fileExtensionRead();
    }

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




    public void readFile() throws FileNotFoundException {
        Csv csv = new Csv(logger);

        List<possibleFile> possibleFiles = Arrays.asList(csv);
        boolean isSupportedFileType = false;
        for (possibleFile file: possibleFiles) {
            if (Objects.equals(file.ToString(), fileExtension)) {
                isSupportedFileType = true;
                file.read(filePath);
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

    }


}
