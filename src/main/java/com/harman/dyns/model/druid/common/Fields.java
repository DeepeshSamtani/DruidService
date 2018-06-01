package com.harman.dyns.model.druid.common;

import java.util.ArrayList;
import java.util.List;

public class Fields {

	private String type;
	private String dimension;
	private String value;
	private String function;
	private List<Fields> fields;
	private String lower;
	private String ordering;
	private Boolean lowerStrict;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}

	public String getLower() {
		return lower;
	}

	public void setLower(String lower) {
		this.lower = lower;
	}

	public String getOrdering() {
		return ordering;
	}

	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	public Boolean getLowerStrict() {
		return lowerStrict;
	}

	public void setLowerStrict(Boolean lowerStrict) {
		this.lowerStrict = lowerStrict;
	}

	@Override
	public String toString() {
		return "Fields [type=" + type + ", dimension=" + dimension + ", value=" + value + ", function=" + function
				+ ", fields=" + fields + ", lower=" + lower + ", ordering=" + ordering
				+ ", lowerStrict=" + lowerStrict + "]";
	}	
}
