package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Describes all the possible values to the "units" query param on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
@RequiredArgsConstructor
public enum UnitsEnum {
	
	METERS("m"),
	KILOMETERS("km"),
	MILES("mi");
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static UnitsEnum getByStr(String value) {
		for (UnitsEnum profile : UnitsEnum.values()) {
			if(profile.getValue().toUpperCase().equals(value.toUpperCase()))
				return profile;
		}
		return null;
	}
	
	public String toString() {
		return value;
	}
	
}
