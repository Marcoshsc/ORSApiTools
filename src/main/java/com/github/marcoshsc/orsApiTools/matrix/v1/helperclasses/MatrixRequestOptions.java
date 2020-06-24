package com.github.marcoshsc.orsApiTools.matrix.v1.helperclasses;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Represent the response options of a matrix request. It is guaranteed to have a profile and units value.
 *
 * @author Marcos Henrique
 */
public class MatrixRequestOptions {

    /**
     * Vehicle profile used.
     */
    private EnumProfile profile;
    /**
     * Measurement units used.
     */
    private UnitsEnum units;
    /**
     * List of coordinates passed.
     */
    private List<Coordinate> locations;
    /**
     * Source indexes in the location array passed.
     */
    private List<Integer> sources;
    /**
     * Destination indexes in the location array passed.
     */
    private List<Integer> destinations;

    public MatrixRequestOptions(EnumProfile profile, UnitsEnum units) {
        this.profile = profile;
        this.units = units;
    }

    public EnumProfile getProfile() {
        return profile;
    }

    public UnitsEnum getUnits() {
        return units;
    }

    public List<Coordinate> getLocations() {
        return locations;
    }

    public List<Integer> getSources() {
        return sources;
    }

    public List<Integer> getDestinations() {
        return destinations;
    }

    public void setLocations(List<Coordinate> locations) {
        this.locations = locations;
    }

    public void setSources(List<Integer> sources) {
        this.sources = sources;
    }

    public void setDestinations(List<Integer> destinations) {
        this.destinations = destinations;
    }
}
