package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.AttributesEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * References the "attributes" query parameter on the ORS API.
 * 
 * Parameter description: Pipe (|) separated List of route attributes:
 * avgspeed - Returns average speed of each segment and the route in km/h.
 * detourfactor - Returns the deviation of a segment compared to a straight line (1) from A to B.
 * percentage - Returns the proportion of the route for each segment.
 * 
 * Makes use of AttributesEnum to map all the possible values.
 * 
 * @see AttributesEnum to understand all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Attributes implements QueryParameter<List<AttributesEnum>> {
	
	private final String name = ORSEnum.ATTRIBUTES_PARAM.toString();
	
	private List<AttributesEnum> value;
	
	public Attributes(AttributesEnum value) {
		this.value = new ArrayList<>();
		this.value.add(value);
	}

	public Attributes(List<AttributesEnum> value) {
		super();
		this.value = value;
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
	public List<AttributesEnum> getTypedValue() {
		return value;
	}

}
