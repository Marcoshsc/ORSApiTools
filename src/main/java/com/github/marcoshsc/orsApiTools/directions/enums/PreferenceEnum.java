package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Describes all the possible values to the "preference" query param on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public enum PreferenceEnum {
	
	FASTEST("fastest"),
	SHORTEST("shortest"),
	RECOMMENDED("recommended");
	
	private String value;
	
	private PreferenceEnum(String value) {
		this.value = value;
	}

	public static PreferenceEnum getByStr(String value) {
		for (PreferenceEnum profile :
				PreferenceEnum.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}
	
	public String toString() {
		return value;
	}
	
}
