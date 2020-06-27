package com.github.marcoshsc.orsApiTools.pois;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeneralBoundingBoxDeserializer;
import com.github.marcoshsc.orsApiTools.json.deserializers.PoisInformationDeserializer;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisLocation;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisResponseOptions;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Abstraction of a POIS response from the ORS API.
 * https://github.com/GIScience/openpoiservice for more information
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoisResponse {

    /**
     * Array of coordinates representing the bounding box where the points of interest is contained.
     */
    private final BoundingBox boundingBox;

    /**
     * Array of found locations
     */
    private final List<PoisLocation> features;

    /**
     * Some of the request values passed when making this response.
     */
    private final PoisResponseOptions options;

    public PoisResponse(@JsonProperty("bbox")
                        @JsonDeserialize(using = GeneralBoundingBoxDeserializer.class)
                                BoundingBox boundingBox,
                        @JsonProperty(value = "features", required = true)
                                List<PoisLocation> features,
                        @JsonProperty("information")
                        @JsonDeserialize(using = PoisInformationDeserializer.class)
                            PoisResponseOptions options) {
        this.boundingBox = boundingBox;
        this.features = features;
        this.options = options;
    }

}
