package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Define all the possible values to the "instructions_format" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
@RequiredArgsConstructor
public enum InstructionsFormatEnum {
	
	HTML("html"),
	TEXT("text");
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static InstructionsFormatEnum getByStr(String value) {
		for (InstructionsFormatEnum profile :
				InstructionsFormatEnum.values()) {
			if(profile.getValue().toUpperCase().equals(value.toUpperCase()))
				return profile;
		}
		throw new IllegalArgumentException("Invalid instruction format.");
	}
	
	public String toString() {
		return value;
	}
}
