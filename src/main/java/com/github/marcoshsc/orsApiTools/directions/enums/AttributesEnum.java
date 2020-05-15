package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Define all the possible values to the "attributes" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public enum AttributesEnum {
	
	AVERAGE_SPEED("avgspeed"),
	DETOUR_FACTOR("detourfactor"),
	PERCENTAGE("percentage");
	
	private String value;
	
	private AttributesEnum(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
