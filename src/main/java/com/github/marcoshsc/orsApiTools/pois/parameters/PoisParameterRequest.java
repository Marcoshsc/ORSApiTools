package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Type of the request to be made. Currently the only supported value is "pois".
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class PoisParameterRequest {

    /**
     * The type of the request.
     */
    @JsonValue
    private final PoisRequestEnum value;

}
