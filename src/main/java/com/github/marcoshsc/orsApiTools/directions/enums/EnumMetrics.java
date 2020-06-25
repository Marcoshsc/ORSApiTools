package com.github.marcoshsc.orsApiTools.directions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Metrics possible values mapping.
 *
 * @author Marcos Henrique
 */
public enum EnumMetrics {
	DISTANCE ("distance"), DURATION ("duration");

	private final String type;

	EnumMetrics(String type) {
		this.type = type;
	}

	@JsonValue
	public String getType() {
		return type;
	}

	@JsonCreator
	public EnumMetrics getFromString(String value) {
		for (EnumMetrics attribute : EnumMetrics.values()) {
			if(attribute.getType().toUpperCase().equals(value.toUpperCase()))
				return attribute;
		}
		throw new IllegalArgumentException("Invalid Attribute.");
	}

	public String toString() {
		return type;
	}
}
