package FileManagment.sources;

import FileManagment.FileManager;
import FileManagment.Validator;
import models.Collection;
import models.MusicBand;
import models.MusicGenre;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Csv executing
 */
public class Csv extends possibleFile {
    public Csv(Logger logger, String path) {
        super(logger, path);
    }

    /**
     * write
     * @param collection
     * @throws IOException
     */
    public void writeCsvFile(Collection collection) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "MacCyrillic"));
        bw.append("id (авто)");
        bw.append(",");
        bw.append("Название");
        bw.append(",");
        bw.append("Дата создания записи (авто)");
        bw.append(",");
        bw.append("Число участников");
        bw.append(",");
        bw.append("Описание");
        bw.append(",");
        bw.append("Дата создания группы");
        bw.append(",");
        bw.append("Жанр");
        bw.append(",");
        bw.append("Расположение по X");
        bw.append(",");
        bw.append("Расположение по Y");
        bw.append(",");
        bw.append("Название лучшего альбома");
        bw.append(",");
        bw.append("Треки");
        bw.append(",");
        bw.append("Длина");
        bw.newLine();
        for (MusicBand element : collection.getCollection()) {
            bw.append(Long.toString(element.getId()));
            bw.append(",");
            bw.append(element.getName());
            bw.append(",");
            bw.append(element.getCreationDate());
            bw.append(",");
            bw.append(String.valueOf(element.getNumberOfParticipants()));
            bw.append(",");
            bw.append(element.getDescription());
            bw.append(",");
            bw.append(element.getEstablishmentDate());
            bw.append(",");
            bw.append(element.getGenre());
            bw.append(",");
            bw.append(Long.toString(element.getX()));
            bw.append(",");
            bw.append(Long.toString(element.getY()));
            bw.append(",");
            bw.append(element.getBestAlbumName());
            bw.append(",");
            bw.append(Long.toString(element.getTracks()));
            bw.append(",");
            bw.append(String.valueOf(element.getLength()));

            bw.newLine();
        }
        bw.close();
    }

    /**
     * read
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public Collection read(String filePath) throws FileNotFoundException {
        InputStream targetStream = null;
        try {
            File initialFile = new File(filePath);
            if (!initialFile.exists()) {logger.log(Level.WARNING, "File not found!"); System.exit(1);}
            targetStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Permission denied!");
            System.exit(1);
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(targetStream, "MacCyrillic"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Collection collection = new Collection();
        TreeSet<MusicBand> treeSet = new TreeSet<>();
        String line;
        int index = 0;
        try {
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(";");
                if (index != 0 && lineArr.length > 0) {
                    boolean possibleToAdd = Validator.validate(lineArr, logger);
                    if (possibleToAdd) {
                        treeSet.add(new MusicBand(lineArr));
                    }
                }
                index++;
            }
            collection.setCollection(treeSet);
            return collection;
        } catch (NoSuchElementException | NullPointerException | IllegalStateException exception) {

            logger.log(Level.WARNING, "NoSuchElementException | NullPointerException | IllegalStateException!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(1);
        return null;
    }

    @Override
    public String ToString() {
        return "csv";
    }
}
