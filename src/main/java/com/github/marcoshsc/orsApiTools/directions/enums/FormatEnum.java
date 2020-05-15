package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Map all the possible values to the "format" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public enum FormatEnum {
	
	JSON("json"),
	GEOJSON("geojson"),
	GPX("gpx");
	
	private String value;
	
	private FormatEnum(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
