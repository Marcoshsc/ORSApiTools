package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.json.serializers.CoordinateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describe a vehicle for optimization requests.
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Vehicle {

    /**
     * Unique Identifier.
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * Routing profile (defaults to car)
     */
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EnumProfile profile;

    /**
     * Coordinates array
     */
    @JsonProperty("start")
    @JsonSerialize(using = CoordinateSerializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Coordinate start;

    /**
     * Index of relevant row and column in custom matrix
     */
    @JsonProperty("start_index")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer startIndex;

    /**
     * Coordinates array
     */
    @JsonProperty("end")
    @JsonSerialize(using = CoordinateSerializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Coordinate end;

    /**
     * Index of relevant row and column in custom matrix
     */
    @JsonProperty("end_index")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer endIndex;

    /**
     * An array of integers describing multidimensional quantities
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> capacity;

    /**
     * An array of integers defining skills
     */
    @JsonProperty("skills")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> skills;

    /**
     * A time_window object describing working hours
     */
    @JsonProperty("time_window")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TimeWindow timeWindow;

    /**
     * An array of break objects
     */
    @JsonProperty("breaks")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Break> breaks;

}
