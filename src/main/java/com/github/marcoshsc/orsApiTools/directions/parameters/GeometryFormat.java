package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumDirectionsGeomType;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * References the "geometry_format" query parameter on the ORS API.
 * Parameter description: Sets the format of the returned geometry.
 * Makes use of EnumDirectionsGeomType to map all the possible values.
 * 
 * The default value is "encodedpolyline".
 * 
 * @see EnumDirectionsGeomType to see all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class GeometryFormat extends EnumParameter<EnumDirectionsGeomType> {

	private final String name = ORSEnum.GEOMETRY_FORMAT_PARAM.toString();

	public GeometryFormat(EnumDirectionsGeomType value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
