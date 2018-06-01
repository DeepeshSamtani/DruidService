package com.harman.harmannpm.indexing.model;

public class DruidJobDetails {
	private Spec spec;

	private String type;

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ClassPojo [spec = " + spec + ", type = " + type + "]";
	}

}
