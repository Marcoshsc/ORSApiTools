package com.github.marcoshsc.orsApiTools.geocode.helperclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a simple bounding box with 4 coordinates. This class should be read-only.
 *
 * @author Marcos Henrique in 28-04-2020
 */
@Getter
@ToString
@AllArgsConstructor
public class BoundingBox {

    private final double minLatitude;
    private final double maxLatitude;
    private final double minLongitude;
    private final double maxLongitude;

//    public BoundingBox(double minLatitude, double maxLatidude, double minLongitude, double maxLongitude) {
//        this.minLatitude = minLatitude;
//        this.maxLatidude = maxLatidude;
//        this.minLongitude = minLongitude;
//        this.maxLongitude = maxLongitude;
//    }
//
//    public double getMinLatitude() {
//        return minLatitude;
//    }
//
//    public double getMaxLatidude() {
//        return maxLatidude;
//    }
//
//    public double getMinLongitude() {
//        return minLongitude;
//    }
//
//    public double getMaxLongitude() {
//        return maxLongitude;
//    }
//
//    @Override
//    public String toString() {
//        return "BoundingBox{" +
//                "minLatitude=" + minLatitude +
//                ", maxLatidude=" + maxLatidude +
//                ", minLongitude=" + minLongitude +
//                ", maxLongitude=" + maxLongitude +
//                '}';
//    }
}
