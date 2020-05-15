package com.github.marcoshsc.orsApiTools.matrix.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * References the metrics query parameter on the ORS API.
 * 
 * Parameter description: Specifies a list of returned metrics separated with a pipe character (|).
 * distance - Returns distance matrix for specified points in defined units.
 * duration - Returns duration matrix for specified points in seconds.
 * 
 * Makes use of EnumMetrics to map all the possible values.
 * 
 * The default value is duration.
 * 
 * @see EnumMetrics to see all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 16-03-2020
 *
 */
public class Metrics implements QueryParameter<List<EnumMetrics>> {
	
	private final String name = ORSEnum.METRICS_PARAM.toString();

	/**
	 * List of metrics to be used.
	 */
	private List<EnumMetrics> value;
	
	public Metrics(EnumMetrics value) {
		this.value = new ArrayList<>();
		this.value.add(value);
	}

	public Metrics(List<EnumMetrics> value) {
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
	public List<EnumMetrics> getTypedValue() {
		return value;
	}

}
