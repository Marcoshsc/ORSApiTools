package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Describe all the possible values to the "extra_info" query parameter, from the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
@RequiredArgsConstructor
public enum ExtraInfoEnum {
	
	STEEPNESS("steepness"),
	SUITABILITY("suitability"),
	SURFACE("surface"),
	WAY_CATEGORY("waycategory"),
	WAY_TYPE("waytype"),
	TOLL_WAYS("tollways"),
	TRAIL_DIFFICULTY("traildifficulty"),
	ROAD_ACCESS_RESTRICTIONS("roadaccessrestrictions"),
	AVERAGE_SPEED("avgspeed"),
	COUNTRY_INFO("countryinfo");
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static ExtraInfoEnum GetFromString(String value) {
		for (ExtraInfoEnum e : ExtraInfoEnum.values()) {
			if(e.getValue().toUpperCase().equals(value.toUpperCase()))
				return e;
		}
		throw new IllegalArgumentException("Invalid extra info value.");
	}
	
}
