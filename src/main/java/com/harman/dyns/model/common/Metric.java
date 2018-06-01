package com.harman.dyns.model.common;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Metric extends Attribute {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 8753632275556681164L;
	
	private String aggregationType;
	private String formula;
	//private String fieldName;
	//private String name;

	public String getAggregationType() {
		return aggregationType;
	}

	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}
	
	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "Metric [aggregationType=" + aggregationType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggregationType == null) ? 0 : aggregationType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metric other = (Metric) obj;
		if (aggregationType == null) {
			if (other.aggregationType != null)
				return false;
		} else if (!aggregationType.equals(other.aggregationType))
			return false;
		return true;
	}
	
}
