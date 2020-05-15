package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * 
 * Enum that describes all the possible values to the profile query param, from the ORS API.
 *
 */
public enum EnumProfile {
	
	DRIVING_CAR("driving-car"), 
	DRIVING_HGV("driving-hgv"),
	CYCLING_REGULAR("cycling-regular"),
	CYCLING_ROAD("cycling-road"),
	CYCLING_MOUNTAIN("cycling-mountain"),
	CYCLING_ELETRIC("cycling-electric"),
	FOOT_WALKING("foot-walking"),
	FOOT_HIKING("foot-hiking"),
	WHEELCHAIR("wheelchair");
	
	private String m_Type;
	private EnumProfile(String p_Type) {
		m_Type = p_Type;
	}

	public static EnumProfile getByStr(String value) {
		for (EnumProfile profile :
				EnumProfile.values()) {
			if(profile.toString().equals(value))
				return profile;
		}
		return null;
	}

	public String toString() {
		return m_Type;
	}
}
