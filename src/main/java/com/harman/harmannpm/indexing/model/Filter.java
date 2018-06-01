package com.harman.harmannpm.indexing.model;

public class Filter {
	private String type;

	private Fields[] fields;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Fields[] getFields() {
		return fields;
	}

	public void setFields(Fields[] fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "ClassPojo [type = " + type + ", fields = " + fields + "]";
	}
}
