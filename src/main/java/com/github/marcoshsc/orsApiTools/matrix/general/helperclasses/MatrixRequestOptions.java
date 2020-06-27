package com.github.marcoshsc.orsApiTools.matrix.general.helperclasses;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Represent the response options of a matrix request. It is guaranteed to have a profile and units value.
 *
 * @author Marcos Henrique
 */
@Getter
public class MatrixRequestOptions {

    /**
     * Vehicle profile used.
     */
    private final EnumProfile profile;

    /**
     * Measurement units used.
     */
    private final UnitsEnum units;

    /**
     * List of coordinates passed.
     */
    @Setter
    private List<Coordinate> locations;

    /**
     * Source indexes in the location array passed.
     */
    @Setter
    private List<Integer> sources;

    /**
     * Destination indexes in the location array passed.
     */
    @Setter
    private List<Integer> destinations;

    public MatrixRequestOptions(EnumProfile profile, UnitsEnum units) {
        this.profile = profile;
        this.units = units;
    }
}
