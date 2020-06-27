package com.github.marcoshsc.orsApiTools.isochrones.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    private final Integer groupIndex;
    private final Double value;

    @JsonDeserialize(using = CoordinateDeserializer.class)
    private final Coordinate center;

    private final Double area;
    private final Double reachFactor;
    private final Double totalPopulation;

    @JsonCreator
    public Properties(@JsonProperty(value = "group_index", required = true) Integer groupIndex,
                      @JsonProperty(value = "value", required = true) Double value,
                      @JsonProperty(value = "center", required = true) Coordinate center,
                      @JsonProperty(value = "area") Double area,
                      @JsonProperty(value = "reachfactor") Double reachFactor,
                      @JsonProperty(value = "total_pop") Double totalPopulation) {
        this.groupIndex = groupIndex;
        this.value = value;
        this.center = center;
        this.area = area;
        this.reachFactor = reachFactor;
        this.totalPopulation = totalPopulation;
    }
}
