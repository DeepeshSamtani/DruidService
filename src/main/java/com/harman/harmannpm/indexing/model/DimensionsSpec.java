package com.harman.harmannpm.indexing.model;

public class DimensionsSpec {

	private String[] dimensionExclusions;

	private String[] dimensions;

	public String[] getDimensionExclusions() {
		return dimensionExclusions;
	}

	public void setDimensionExclusions(String[] dimensionExclusions) {
		this.dimensionExclusions = dimensionExclusions;
	}

	public String[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(String[] dimensions) {
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "ClassPojo [dimensionExclusions = " + dimensionExclusions + ", dimensions = " + dimensions + "]";
	}
}
