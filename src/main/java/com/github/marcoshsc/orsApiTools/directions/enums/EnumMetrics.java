package com.github.marcoshsc.orsApiTools.directions.enums;

/**
 * Metrics possible values mapping.
 *
 * @author Marcos Henrique
 */
public enum EnumMetrics {
	DISTANCE ("distance"), DURATION ("duration");
	private String m_Type;
	EnumMetrics(String p_Type) {
		m_Type = p_Type;
	}
	
	public String toString() {
		return m_Type;
	}
}
