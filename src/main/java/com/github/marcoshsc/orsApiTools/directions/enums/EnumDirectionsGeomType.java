package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * Geometry format possible values.
 *
 * @author Marcos Henrique
 */
public enum EnumDirectionsGeomType {
	ENCODEDPOLYLINE("encodedpolyline"), POLYLINE("polyline"), GEOJSON("geojson");
	private String m_Type;
	
	EnumDirectionsGeomType(String p_Type) {
		m_Type = p_Type;
	}

	public static EnumDirectionsGeomType getByStr(String value) {
		for (EnumDirectionsGeomType profile :
				EnumDirectionsGeomType.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}

	@Override
	public String toString() {
		return m_Type;
	}
}
