package com.github.marcoshsc.orsApiTools.matrix.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.List;

/**
 * 
 * Class for definition of the destinations query parameter, used in GET requests to the ORS API.
 * 
 * Parameter definition: A comma separated list of indices that refers to the list of locations (starting with 0) or "all" (default).
 * 
 * 
 * @author Marcos Henrique Santos Cunha in 15-03-2020
 *
 */
public class Destinations implements QueryParameter<List<Integer>> {
	
	private final String name = ORSEnum.DESTINATIONS_PARAM.toString();

	private List<Integer> value;

	public Destinations(List<Integer> value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Return the string value referent to the stored coordinates.
	 */
	@Override
	public String getValue() {
		return UtilityFunctions.groupAllByComma(value);
	}

	@Override
	public List<Integer> getTypedValue() {
		return value;
	}

}