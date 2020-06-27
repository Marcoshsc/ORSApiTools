package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.pois.enums.FeeEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.SmokingEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.WheelChairEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Filters in terms of osm_tags which should be applied to the query.
 * Set to null filters that won't be used.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class Filters {

    /**
     * List of integers representing category group IDs to filter the response.
     */
    @JsonProperty("category_group_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Integer> categoryGroupIds;

    /**
     * List of integers representing category IDs to filter the response.
     */
    @JsonProperty("category_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Integer> categoryIds;

    /**
     * List of location names to be accepted as response.
     */
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> names;

    /**
     * List of integers representing wheelchair accessibility required in returned locations.
     */
    @JsonProperty("wheelchair")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<WheelChairEnum> wheelchair;

    /**
     * List of integers representing smoking rules required in returned locations.
     */
    @JsonProperty("smoking")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<SmokingEnum> smoking;

    /**
     * List of integers representing fee rules required in returned locations.
     * Fee refers to pay money to enter/use the place.
     */
    @JsonProperty("fee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<FeeEnum> fee;

}
