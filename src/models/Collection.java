package models;

import java.util.Date;
import java.util.TreeSet;
/**
 * Collection data class
 */
public class Collection {
    private TreeSet<MusicBand> treeSet;
    private final String initializeTime;
    private String lastSaveTime;

    public Collection() {
        Date date = new Date();
        this.initializeTime = date.toString();
    }

    public String information() {
        return "Сведения о коллекции:\nТип коллекции: " + treeSet.getClass().getName() +
                "\nРазмер: " + treeSet.size() + "\nВремя инициализации: " + initializeTime +
                "\nВремя последнего обновления: " + lastSaveTime;
    }

    public void setCollection(TreeSet<MusicBand> treeSet) {
        Date date = new Date();
        this.lastSaveTime = date.toString();
        this.treeSet = treeSet;
    }

    public TreeSet<MusicBand> getCollection() {
        return this.treeSet;
    }
}
