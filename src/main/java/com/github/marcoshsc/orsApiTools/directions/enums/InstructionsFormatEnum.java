package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Define all the possible values to the "instructions_format" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public enum InstructionsFormatEnum {
	
	HTML("html"),
	TEXT("text");
	
	private String value;
	
	private InstructionsFormatEnum(String value) {
		this.value = value;
	}

	public static InstructionsFormatEnum getByStr(String value) {
		for (InstructionsFormatEnum profile :
				InstructionsFormatEnum.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}
	
	public String toString() {
		return value;
	}
}
