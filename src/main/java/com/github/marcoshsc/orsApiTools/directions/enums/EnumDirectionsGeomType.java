package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Geometry format possible values.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
public enum EnumDirectionsGeomType {

	ENCODEDPOLYLINE("encodedpolyline"), POLYLINE("polyline"), GEOJSON("geojson");

	private final String type;

	@JsonValue
	public String getType() {
		return type;
	}

	@JsonCreator
	public static EnumDirectionsGeomType getByStr(String value) {
		for (EnumDirectionsGeomType profile :
				EnumDirectionsGeomType.values()) {
			if(profile.getType().toUpperCase().equals(value.toUpperCase()))
				return profile;
		}
		throw new IllegalArgumentException("Invalid geometry type.");
	}

	@Override
	public String toString() {
		return type;
	}
}
