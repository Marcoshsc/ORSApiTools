package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Every fields contained in a extra_info field.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraInfoField {

    /**
     * Broken down by way_points.
     */
    private final List<ExtraInfoValues> values;

    /**
     * Broken down by information category values.
     */
    private final List<ExtraInfoSummary> summary;

    @JsonCreator
    public ExtraInfoField(@JsonProperty(value = "values", required = true)
                                  List<ExtraInfoValues> values,
                          @JsonProperty(value = "summary", required = true) List<ExtraInfoSummary> summary) {
        this.values = values;
        this.summary = summary;
    }

}
