package com.github.marcoshsc.orsApiTools.general.enums;

public enum ORSEnum {
	
	COMMA("%2C"),
	
	COORDINATE_BAR("%7C"),
	
	BASE_URL("https://api.openrouteservice.org"),
	
	DIRECTIONS_PATH("directions"),

	GEOCODE_PATH("geocode"),

	/**
	 * cannot be used alone.
	 */
	GEOCODE_SEARCH_PATH("search"),

	POIS_PATH("pois"),

	OPTIMIZATION_PATH_PARAM("optimization"),

	API_KEY_PARAM("api_key"),
	
	COORDINATES_PARAM("coordinates"),
	
	PROFILE_PARAM("profile"),
	
	PREFERENCE_PARAM("preference"),
	PREFERENCE_VALUE_FASTEST("fastest"),
	
	FORMAT_PARAM("format"),
	FORMAT_VALUE_JSON("json"),
	
	UNITS_PARAM("units"),
	UNITS_VALUE_M("m"),
	
	LANGUAGE_PARAM("language"),
	LANGUAGE_VALUE_ENGLISH("en"),
	
	GEOMETRY_PARAM("geometry"),
	GEOMETRY_VALUE_TRUE("true"),
	
	GEOMETRY_FORMAT_PARAM("geometry_format"),
	
	GEOMETRY_SIMPLIFY_PARAM("geometry_simplify"),
	
	INSTRUCTIONS_PARAM("instructions"),
	INSTRUCTIONS_VALUE_TRUE("true"),
	
	INSTRUCTIONS_FORMAT_PARAM("instructions_format"),
	INSTRUCTIONS_FORMAT_VALUE_TEXT("text"),
	
	ROUNDABOUT_EXISTS_PARAM("roundabout_exists"),
	
	ATTRIBUTES_PARAM("attributes"),
	
	MANEUVERS_PARAM("maneuvers"),
	
	RADIUSES_PARAM("radiuses"),
	RADIUSES_VALUE("-1%7C-1"),
	
	BEARINGS_PARAM("bearings"),
	
	ELEVATION_PARAM("elevation"),

	CONTINUE_STRAIGHT_PARAM("continue_straight"),
	
	EXTRAINFO_PARAM("extra_info"),
	EXTRAINFO_VALUE_WAYCATEGORY("WayCategory"),
	
	OPTIMIZED_PARAM("optimized"),
	OPTIMIZED_VALUE_TRUE("true"),
	
	OPTIONS_PARAM("options"),
	OPTIONS_VALUE("%7B%7D"),
	
	ID_PARAM("id"),
	
	MATRIX_PATH("matrix"),
	
	LOCATIONS_PARAM("locations"),
	
	SOURCES_PARAM("sources"),
	
	METRICS_PARAM("metrics"),
	
	RESOLVE_LOCATIONS_PARAM("resolve_locations"),
	
	DESTINATIONS_PARAM("destinations"),

	TEXT_PARAM("text"),

	FOCUS_POINT_LONGITUDE_PARAM("focus.point.lon"),

	FOCUS_POINT_LATITUDE_PARAM("focus.point.lat"),

	SOURCES_GEOCODE_PARAM("sources"),

	SIZE_PARAM("size"),
	
	SUPPRESS_WARNINGS_PARAM("supress_warnings"),

	LAYERS_PARAM("layers"),

	BOUNDARY_RECTANGLE_MINIMUM_LATITUDE("boundary.rect.min_lat"),

	BOUNDARY_RECTANGLE_MAXIMUM_LATITUDE("boundary.rect.max_lat"),

	BOUNDARY_RECTANGLE_MINIMUM_LONGITUDE("boundary.rect.min_lon"),

	BOUNDARY_RECTANGLE_MAXIMUM_LONGITUDE("boundary.rect.max_lon"),

	BOUNDARY_CIRCLE_LATITUDE("boundary.circle.lat"),

	BOUNDARY_CIRCLE_LONGITUDE("boundary.circle.lon"),

	BOUNDARY_CIRCLE_RADIUS("boundary.circle.radius"),

	BOUNDARY_GEOGRAPHIC_ID("boundary.gid"),

	BOUNDARY_COUNTRY("boundary.country"),

	REQUEST_BODY_PARAM("request"),

	FILTERS_BODY_PARAM("filters"),

	LIMIT_BODY_PARAM("limit"),

	SORT_BY_BODY_PARAM("sortby"),

	JOBS_BODY_PARAM("jobs"),

	VEHICLES_BODY_PARAM("vehicles"),

	SHIPMENTS_BODY_PARAM("shipments");
	
	private String value;
	
	ORSEnum(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
}
