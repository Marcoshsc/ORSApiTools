package com.github.marcoshsc.orsApiTools.matrix.v1;

import com.github.marcoshsc.orsApiTools.general.parameters.*;
import com.github.marcoshsc.orsApiTools.interfaces.ParameterList;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.matrix.v1.parameters.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Set of query parameters used in requests to the ORS API, in the matrix path.
 * Implements ParameterList, which means there is a method called getUsedParameters(),
 * that returns the not null fields on the object.
 * 
 * By default, all the fields are null. The user must make it's own configuration.
 * 
 * @author Marcos Henrique Santos Cunha in 21-03-2020
 *
 */
@Getter
@Setter
@ToString
public class MatrixParameters implements ParameterList {

	/**
	 * API key to be used.
	 */
	private ApiKey apiKey;
	/**
	 * Specifies the route profile.
	 */
	private Profile profile;
	/**
	 * Pipe (|) separated List of longitude,latitude coordinates
	 */
	private Locations locations;
	/**
	 * A comma separated list of indices that refers to the list of locations.
	 */
	private Sources sources;
	/**
	 * A comma separated list of indices that refers to the list of locations.
	 */
	private Destinations destinations;
	/**
	 * Specifies a list of returned metrics separated with a pipe character (|).
	 *
	 * distance - Returns distance matrix for specified points in defined units.
	 * duration - Returns duration matrix for specified points in seconds.
	 */
	private Metrics metrics;
	/**
	 * Specifies whether given locations are resolved or not. If the parameter value set to true, every element in
	 * destinations and sources will contain the name element that identifies the name of the closest street.
	 * Default: false
	 */
	private ResolveLocations resolveLocations;
	/**
	 * Specifies whether Dijkstra algorithm (false) or any available technique to speed up shortest-path routing (true)
	 * is used. For normal Dijkstra the number of visited nodes is limited to 100000
	 */
	private Optimized optimized;
	/**
	 * Specifies the unit of measurement for distances (only).
	 */
	private Units units;
	/**
	 * Arbitrary identification string of the request reflected in the meta information.
	 */
	private Id id;

	/**
	 *
	 * @return a list of all not-null fields on the object.
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
