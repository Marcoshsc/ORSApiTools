package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.directions.enums.*;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateListDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describe useful information about the request that generated the response. Note that some fields can be null and it
 * must be checked before it's use.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestOptions {

    /**
     * Vehicle profile used.
     */
    private final EnumProfile profile;

    /**
     * Preference chosen.
     */
    private final PreferenceEnum preference;

    /**
     * List of coordinates passed to the request.
     */
    private final List<Coordinate> coordinates;

    /**
     * Language of the response.
     */
    private final LanguageEnum language;

    /**
     * Measurement unit used.
     */
    private final UnitsEnum units;

    /**
     * If geometry is present.
     */
    private final boolean geometry;

    /**
     * Format of geometry.
     */
    private final EnumDirectionsGeomType geometryFormat;

    /**
     * Format of instructions in the response.
     */
    private final InstructionsFormatEnum instructionsFormat;

    /**
     * If instructions are present.
     */
    private final boolean instructions;

    /**
     * If elevation data is present.
     */
    private final boolean elevation;

    @JsonCreator
    public RequestOptions(@JsonProperty("profile")
                                  EnumProfile profile,
                          @JsonProperty("preference")
                                  PreferenceEnum preference,
                          @JsonProperty("coordinates")
                          @JsonDeserialize(using = CoordinateListDeserializer.class)
                                  List<Coordinate> coordinates,
                          @JsonProperty("language")
                                  LanguageEnum language,
                          @JsonProperty("units")
                                  UnitsEnum units,
                          @JsonProperty("geometry")
                                  boolean geometry,
                          @JsonProperty("geometry_format")
                                  EnumDirectionsGeomType geometryFormat,
                          @JsonProperty("instructions_format")
                                  InstructionsFormatEnum instructionsFormat,
                          @JsonProperty("instructions")
                                  boolean instructions,
                          @JsonProperty("elevation")
                                  boolean elevation) {
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

}
