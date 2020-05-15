package com.github.marcoshsc.orsApiTools.general.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * References the "units" query parameter on the ORS API.
 * Parameter description: Specifies the distance unit.
 * Makes use of UnitsEnum to map all the possible values.
 * 
 * The default value is "m" (Meters).
 * 
 * @see UnitsEnum to understand all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class Units extends EnumParameter<UnitsEnum> {

	private final String name = ORSEnum.UNITS_PARAM.toString();

	public Units(UnitsEnum value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
