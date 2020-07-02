package com.github.marcoshsc.orsApiTools.directions.v1;

import com.github.marcoshsc.orsApiTools.directions.v1.parameters.*;
import com.github.marcoshsc.orsApiTools.general.parameters.*;
import com.github.marcoshsc.orsApiTools.interfaces.ParameterList;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Set of query parameters used in requests to the ORS API, in the directions path.
 * Implements ParameterList, which means there is a method called getUsedParameters(),
 * that returns the not null fields on the object.
 * 
 * By default, all the fields are null. The user must make it's own configuration.
 * NOTE: check if a parameter has a default value before using it. Parameters with default values does not need to be
 * set.
 * 
 * @author Marcos Henrique Santos Cunha in 21-03-2020
 *
 */
@Getter
@Setter
public class DirectionsParameters implements ParameterList {

	/**
	 * Api key to be used.
	 */
	private ApiKey apiKey;
	/**
	 * Pipe (|) separated List of route attributes
	 */
	private Attributes attributes;
	/**
	 * Forces the route to keep going straight at waypoints restricting uturns there even if it would be faster.
	 */
	private ContinueStraight continueStraight;
	/**
	 * Pipe (|) separated List of longitude,latitude coordinates visited in order.
	 */
	private Coordinates coordinates;
	/**
	 * Specifies whether to return elevation values for points.
	 */
	private Elevation elevation;
	/**
	 * Pipe (|) separated List of additional information.
	 */
	private ExtraInfo extraInfo;
	/**
	 * Specifies the response format.
	 */
	private Format format;
	/**
	 * Specifies whether to return geometry.
	 */
	private Geometry geometry;
	/**
	 * Sets the format of the returned geometry.
	 */
	private GeometryFormat geometryFormat;
	/**
	 * Specifies whether to simplify the geometry.
	 */
	private GeometrySimplify geometrySimplify;
	/**
	 * Arbitrary identification string of the request reflected in the meta information.
	 */
	private Id id;
	/**
	 * Specifies whether to return instructions.
	 */
	private Instructions instructions;
	/**
	 * Text or HTML. Format of instructions returned.
	 */
	private InstructionsFormat instructionsFormat;
	/**
	 * Language for the route instructions.
	 */
	private Language language;
	/**
	 * Specifies whether the maneuver object is included into the step object or not.
	 */
	private Maneuvers maneuvers;
	/**
	 * Whether the route must be optimized or not.
	 */
	private Optimized optimized;
	/**
	 * Specifies the route preference.
	 */
	private Preference preference;
	/**
	 * Specifies the route profile.
	 */
	private Profile profile;
	/**
	 * A pipe (|) delimited list of maximum distances (measured in meters) that limit the search of nearby road segments
	 * to every given waypoint.
	 */
	private Radiuses radiuses;
	/**
	 * Provides bearings of the entrance and all passed roundabout exits.
	 */
	private RoundaboutExits roundaboutExits;
	/**
	 * Tells the system to not return any warning messages and corresponding extra_info.
	 */
	private com.github.marcoshsc.orsApiTools.directions.v1.parameters.SuppressWarnings suppressWarnings;
	/**
	 * Specifies the distance unit.
	 */
	private Units units;
	
	/**
	 * Return all the not-null fields on the object.
	 */
	@Override
	public List<QueryParameter<?>> getUsedParameters() {
		List<QueryParameter<?>> parameters = new ArrayList<>();
		try {
			for(Field f : this.getClass().getDeclaredFields()) {
				Object o;
				o = f.get(this);
				if(o != null)
					parameters.add((QueryParameter<?>)o);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			System.out.println("Something wrong happened with the parameters");
		}
		return parameters;
	}

}
