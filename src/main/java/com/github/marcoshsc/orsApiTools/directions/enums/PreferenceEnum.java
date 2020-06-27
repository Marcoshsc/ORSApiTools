package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Describes all the possible values to the "preference" query param on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
@RequiredArgsConstructor
public enum PreferenceEnum {
	
	FASTEST("fastest"),
	SHORTEST("shortest"),
	RECOMMENDED("recommended");
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static PreferenceEnum getByStr(String value) {
		for (PreferenceEnum profile :
				PreferenceEnum.values()) {
			if(profile.getValue().toUpperCase().equals(value.toUpperCase()))
				return profile;
		}
		throw new IllegalArgumentException("Invalid preference.");
	}
	
	public String toString() {
		return value;
	}
	
}
