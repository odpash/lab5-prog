package models;

import java.util.Formatter;

/**
 * Coordinates data class
 */
public class Coordinates {
    private long x;
    private long y; //Максимальное значение поля: 719

    /**
     * @param x - X coordinate
     * @param y - Y coordinate
     */
    public Coordinates(String x, String y) {
        if (x.length() > 0) {
            this.x = Long.parseLong(x);
        } else {
            this.x = 1;
        }
        if (y.length() > 0) {
            this.y = Long.parseLong(y);
        } else {
            this.y = 1;
        }
        }
    @Override
    public String toString() {
        return new Formatter().format("%d, %d", x, y).toString();
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}

