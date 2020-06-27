package com.github.marcoshsc.orsApiTools.isochrones;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.isochrones.helperclasses.Feature;
import com.github.marcoshsc.orsApiTools.isochrones.helperclasses.Info;
import com.github.marcoshsc.orsApiTools.json.deserializers.IsochronesInfoDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class IsochronesResponse {

    private final List<Feature> features;
    private final List<Double> boundingBox;

    private final Info info;

    @JsonCreator
    public IsochronesResponse(@JsonProperty(value = "features", required = true)
                                      List<Feature> features,

                              @JsonProperty(value = "bbox", required = true)
                                      List<Double> boundingBox,

                              @JsonProperty(value = "metadata", required = true)
                              @JsonDeserialize(using = IsochronesInfoDeserializer.class)
                                      Info info
    ) {
        this.features = features;
        this.boundingBox = boundingBox;
        this.info = info;
    }
}
