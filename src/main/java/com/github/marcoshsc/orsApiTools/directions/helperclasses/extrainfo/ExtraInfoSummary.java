package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * The summary of an {@link ExtraInfoField}. A summary object describes the values showed in the "values" array.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraInfoSummary {

    /**
     * Value of a info category.
     */
    private final double value;

    /**
     * Cumulative distance of this value.
     */
    private final double distance;

    /**
     * Category percentage of the entire route.
     */
    private final double amount;

    @JsonCreator
    public ExtraInfoSummary(@JsonProperty(value = "value", required = true) double value,
                            @JsonProperty(value = "distance", required = true) double distance,
                            @JsonProperty(value = "amount", required = true) double amount) {
        this.value = value;
        this.distance = distance;
        this.amount = amount;
    }

}
