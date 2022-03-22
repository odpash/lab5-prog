package models;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
/**
 * MusicBand data class
 */
public class MusicBand implements Comparable<MusicBand>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private java.time.LocalDateTime establishmentDate; //Поле может быть null
    private MusicGenre genre; //Поле не может быть null
    private Album bestAlbum; //Поле может быть null
    private static Long lastId = 0L;
    public MusicBand() {

    }


    /**
     * @param groupInformation - String Array of 11 params: such as id, name, coordinates (x, y), creationDate, numberOfParticipants, description, establishedDate, genre(enum), bestAlbum and lastId
     */
    public MusicBand(String[] groupInformation) {
        lastId++;
        this.id = lastId;
        this.name = groupInformation[1];
        this.coordinates = new Coordinates(groupInformation[7], groupInformation[8]);
        this.creationDate = ZonedDateTime.now();
        if (groupInformation[3].length() > 0) {
            this.numberOfParticipants = Integer.valueOf(groupInformation[3]);
        } else {
            this.numberOfParticipants = null;
        }
        if (groupInformation[4].length() > 0) {
            this.description = groupInformation[4];
        } else {
            this.description = null;
        }
        if (groupInformation[5].length() > 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
            this.establishmentDate = LocalDate.parse(groupInformation[5], dtf).atStartOfDay();
        } else {
            this.establishmentDate = null;
        }
        this.genre = MusicGenre.valueOf(groupInformation[6]);
        this.bestAlbum = new Album(groupInformation);
    }

    public long getId() {
        return id;
    }
    public String getCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        String formattedString = creationDate.format(formatter);
        return formattedString;
    }
    public int getNumberOfParticipants() {
        try {
            return numberOfParticipants;
        } catch (Exception e) {
            return 1;
        }
    }
    public void setId(Long id) {
        this.id = id;
        lastId = lastId - 1;
    }

    @Override
    public String toString() {
        return new Formatter().format("id: %d, name: %s, coordinates XY: %s, creationDate: %s, numberOfParticipants: %d," +
                "description: %s, establishmentDate: %s, genre: %s, bestAlbum: %s",
                id, name, coordinates.toString(), creationDate, numberOfParticipants, description, establishmentDate, genre, bestAlbum.toString()).toString();

    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(MusicBand o) {
        return name.compareTo(o.name);
    }

    public String getGenre() {
        return genre.name();
    }

    public String getDescription() {
        return description;
    }

    public String getEstablishmentDate() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return establishmentDate.format(formatter);
        } catch (Exception e) {
            return "";
        }
    }

    public long getX() {
        return coordinates.getX();
    }


    public long getY() {
        return coordinates.getY();
    }

    public String getBestAlbumName() {
        return bestAlbum.getName();
    }

    public long getTracks() {
        return bestAlbum.getTracks();
    }

    public int getLength() {
        return bestAlbum.getLength();
    }
}
