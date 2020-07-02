package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Describe all the possible values to the "language" query parameter on the ORS API.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
@RequiredArgsConstructor
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
	
	private final String value;

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static LanguageEnum getByStr(String value) {
		for (LanguageEnum profile :
				LanguageEnum.values()) {
			if(profile.getValue().toUpperCase().equals(value.toUpperCase()))
				return profile;
		}
		throw new IllegalArgumentException("Invalid language.");
	}
	
	public String toString() {
		return value;
	}
	
}
