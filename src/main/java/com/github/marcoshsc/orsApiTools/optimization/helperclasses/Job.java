package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.CoordinateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a job object. The fields are described as follows:
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Job {

    /**
     * unique identifier, must not be null.
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * location of the job.
     */
    @JsonProperty("location")
    @JsonSerialize(using = CoordinateSerializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Coordinate location;

    /**
     * the index of the location in the matrix passed. it's only allowed when an matrix is present in the request.
     */
    @JsonProperty("location_index")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer locationIndex;

    /**
     * Total time spent in the job.
     */
    @JsonProperty("service")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer service;

    /**
     * Array of delivery quantities.
     */
    @JsonProperty("delivery")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> delivery;

    /**
     * Array of pickup quantities.
     */
    @JsonProperty("pickup")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> pickup;

    /**
     * Array of skills needed to do the job.
     */
    @JsonProperty("skills")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> skills;

    /**
     * Priority of the job, [0,100].
     */
    @JsonProperty("priority")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer priority;

    /**
     * List of time windows, which are the periods of time that the job can be started.
     */
    @JsonProperty("time_windows")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TimeWindow> timeWindows;

}
