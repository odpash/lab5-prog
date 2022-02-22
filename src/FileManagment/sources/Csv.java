package FileManagment.sources;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Csv extends possibleFile {
    public Csv(Logger logger) {
        super(logger);
    }

    public void writeCsvFile() {

    }


    @Override
    public TreeSet<Object> read(String filePath) throws FileNotFoundException {
        InputStream targetStream = null;
        try {
            File initialFile = new File(filePath);
            if (!initialFile.exists()) {logger.log(Level.WARNING, "File not found!"); System.exit(1);}
            targetStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Permission denied!");
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(targetStream));
        TreeSet<Object> treeSet = new TreeSet<>();
        TreeSet<TreeSet> info = new TreeSet<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(";");
                Collections.addAll(treeSet, lineArr);
                info.add(treeSet);
            }

            System.out.println(info);
            return treeSet;
        } catch (NoSuchElementException | NullPointerException | IllegalStateException exception) {
            logger.log(Level.WARNING, "Yes");
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
