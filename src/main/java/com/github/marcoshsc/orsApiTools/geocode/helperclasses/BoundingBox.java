package com.github.marcoshsc.orsApiTools.geocode.helperclasses;

/**
 * Represents a simple bounding box with 4 coordinates. This class should be read-only.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public class BoundingBox {

    private double minLatitude;
    private double maxLatidude;
    private double minLongitude;
    private double maxLongitude;

    public BoundingBox(double minLatitude, double maxLatidude, double minLongitude, double maxLongitude) {
        this.minLatitude = minLatitude;
        this.maxLatidude = maxLatidude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public double getMaxLatidude() {
        return maxLatidude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "minLatitude=" + minLatitude +
                ", maxLatidude=" + maxLatidude +
                ", minLongitude=" + minLongitude +
                ", maxLongitude=" + maxLongitude +
                '}';
    }
}
