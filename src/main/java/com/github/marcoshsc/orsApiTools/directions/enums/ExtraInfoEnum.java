package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Describe all the possible values to the "extra_info" query parameter, from the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
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
	
	private String value;
	
	ExtraInfoEnum(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
}
