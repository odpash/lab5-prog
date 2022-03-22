package models;

import java.util.Formatter;
/**
 * Album data class
 */
public class Album {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private long tracks; //Значение поля должно быть больше 0
    private int length; //Значение поля должно быть больше 0

    public Album(String[] source) {
        this.name = source[9];
        if (source.length > 10 && source[10].length() > 0) {
            try {
                this.tracks = Long.parseLong(source[10]);
            } catch (Exception e) {
                this.tracks = 1;
            }
        } else {
            this.tracks = 1;
        }
        if (source.length > 11 && source[11].length() > 0) {
            try {
                this.length = Integer.parseInt(source[11]);
            } catch (Exception e) {
                this.length = 1;
            }
        } else {
            this.length = 1;
        }
    }

    @Override
    public String toString() {
        return new Formatter().format("name: %s, tracks: %d, length: %d", name, tracks, length).toString();
    }

    public String getName() {
        return name;
    }

    public long getTracks() {
        return tracks;
    }

    public int getLength() {
        return length;
    }
}
