package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Describes all the possible values to the "units" query param on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public enum UnitsEnum {
	
	METERS("m"),
	KILOMETERS("km"),
	MILES("mi");
	
	private String value;
	
	private UnitsEnum(String value) {
		this.value = value;
	}

	public static UnitsEnum getByStr(String value) {
		for (UnitsEnum profile :
				UnitsEnum.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}
	
	public String toString() {
		return value;
	}
	
}
