package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.github.marcoshsc.orsApiTools.directions.enums.*;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describe useful information about the request that generated the response. Note that some fields can be null and it
 * must be checked before it's use.
 *
 * @author Marcos Henrique
 */
public class RequestOptions {

    /**
     * Vehicle profile used.
     */
    EnumProfile profile;
    /**
     * Preference chosen.
     */
    PreferenceEnum preference;
    /**
     * List of coordinates passed to the request.
     */
    List<Coordinate> coordinates;
    /**
     * Language of the response.
     */
    LanguageEnum language;
    /**
     * Measurement unit used.
     */
    UnitsEnum units;
    /**
     * If geometry is present.
     */
    boolean geometry;
    /**
     * Format of geometry.
     */
    EnumDirectionsGeomType geometryFormat;
    /**
     * Format of instructions in the response.
     */
    InstructionsFormatEnum instructionsFormat;
    /**
     * If instructions are present.
     */
    boolean instructions;
    /**
     * If elevation data is present.
     */
    boolean elevation;

    public RequestOptions(EnumProfile profile, PreferenceEnum preference, List<Coordinate> coordinates,
                          LanguageEnum language, UnitsEnum units, boolean geometry, EnumDirectionsGeomType geometryFormat,
                          InstructionsFormatEnum instructionsFormat, boolean instructions, boolean elevation) {
        this.profile = profile;
        this.preference = preference;
        this.coordinates = coordinates;
        this.language = language;
        this.units = units;
        this.geometry = geometry;
        this.geometryFormat = geometryFormat;
        this.instructionsFormat = instructionsFormat;
        this.instructions = instructions;
        this.elevation = elevation;
    }

    public EnumProfile getProfile() {
        return profile;
    }

    public PreferenceEnum getPreference() {
        return preference;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public UnitsEnum getUnits() {
        return units;
    }

    public boolean isGeometry() {
        return geometry;
    }

    public EnumDirectionsGeomType getGeometryFormat() {
        return geometryFormat;
    }

    public InstructionsFormatEnum getInstructionsFormat() {
        return instructionsFormat;
    }

    public boolean isInstructions() {
        return instructions;
    }

    public boolean isElevation() {
        return elevation;
    }
}
