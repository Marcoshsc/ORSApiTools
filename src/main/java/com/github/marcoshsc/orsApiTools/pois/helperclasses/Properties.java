package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.PoisCategoryListDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Represent a location's properties, which are the osmId, osmType, distance from the request point, list of categories
 * that the location have, and OSM tags.
 * All the values are guaranteed to not be null.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    /**
     * OSM ID of the location
     */
    private final String osmId;

    /**
     * Location OSM type.
     */
    private final int osmType;

    /**
     * Distance from the given point in the request.
     */
    private final double distance;

    /**
     * List of location categories registered in OSM.
     */
    private final List<PoisCategory> categories;

    /**
     * Location tags.
     */
    private final OSMTags tags;

    @JsonCreator
    public Properties(@JsonProperty(value = "osm_id", required = true)
                              String osmId,
                      @JsonProperty(value = "osm_type", required = true)
                              int osmType,
                      @JsonProperty(value = "distance", required = true)
                              double distance,
                      @JsonProperty(value = "category_ids", required = true)
                      @JsonDeserialize(using = PoisCategoryListDeserializer.class)
                              List<PoisCategory> categories,
                      @JsonProperty(value = "osm_tags", required = true)
                              OSMTags tags) {
        this.osmId = osmId;
        this.osmType = osmType;
        this.distance = distance;
        this.categories = categories;
        this.tags = tags;
    }

}
