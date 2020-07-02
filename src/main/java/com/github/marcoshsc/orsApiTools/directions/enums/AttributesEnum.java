package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Define all the possible values to the "attributes" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
@RequiredArgsConstructor
public enum AttributesEnum {
	
	AVERAGE_SPEED("avgspeed"),
	DETOUR_FACTOR("detourfactor"),
	PERCENTAGE("percentage");
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static AttributesEnum GetFromString(String value) {
		for (AttributesEnum ae : AttributesEnum.values()) {
			if(ae.getValue().toUpperCase().equals(value.toUpperCase()))
				return ae;
		}
		throw new IllegalArgumentException("Invalid attribute value.");
	}

}
