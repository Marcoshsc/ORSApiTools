package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * References the "radiuses" query parameter on the ORS API.
 * Parameter description: A pipe (|) delimited list of maximum distances (measured in meters) 
 * that limit the search of nearby road segments to every given waypoint.
 * The values must be greater than 0, the value of -1 specifies no limit in the search.
 * The number of radiuses correspond to the number of waypoints.
 * 
 * There is no default value, user must pass an array of distances to the constructor.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Radiuses implements QueryParameter<List<Double>> {
	
	private final String name = ORSEnum.RADIUSES_PARAM.toString();
	
	private List<Double> value;
	
	public Radiuses(List<Coordinate> coordinateList) {
		List<Double> newValues = new ArrayList<>();
		for (int i = 0; i < coordinateList.size(); i++) {
			newValues.add(-1d);
		}
		this.value = newValues;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return UtilityFunctions.groupByPipe(value);
	}

	@Override
	public List<Double> getTypedValue() {
		return value;
	}

}
