package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.ExtraInfoValuesDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Describe waypoints and values for the category. Note that wayPoints are just indexes of the geometry object.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonDeserialize(using = ExtraInfoValuesDeserializer.class)
@AllArgsConstructor
public class ExtraInfoValues {

    /**
     * Index of the starting geometry for this section.
     */
    private final int startWayPoint;

    /**
     * Index of the end geometry for this section.
     */
    private final int endWayPoint;

    /**
     * Value assigned to this section.
     */
    private final double value;

}
