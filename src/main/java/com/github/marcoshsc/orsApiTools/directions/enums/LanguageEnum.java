package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Describe all the possible values to the "language" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public enum LanguageEnum {
	
	MAINLAND_CHINA_SIMPLIFIED_CHARACTERS("zh-CN"),
	GERMAN("de"),
	ENGLISH("en"),
	SPANISH("es"),
	RUSSIAN("ru"),
	FRENCH("fr"),
	ITALIAN("it"),
	DUTCH("nl"),
	PORTUGUESE("pt"),
	GREEK("gr"),
	HUNGARIAN("hu");
	
	private String value;
	
	private LanguageEnum(String value) {
		this.value = value;
	}

	public static LanguageEnum getByStr(String value) {
		for (LanguageEnum profile :
				LanguageEnum.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}
	
	public String toString() {
		return value;
	}
	
}
