package com.harman.harmannpm.indexing.model;

public class DruirdDateDetails {

	private String intervalDate;
	private String granularityIntervalDate;
	public String getIntervalDate() {
		return intervalDate;
	}
	public void setIntervalDate(String intervalDate) {
		this.intervalDate = intervalDate;
	}
	public String getGranularityIntervalDate() {
		return granularityIntervalDate;
	}
	public void setGranularityIntervalDate(String granularityIntervalDate) {
		this.granularityIntervalDate = granularityIntervalDate;
	}
	
	@Override
	public String toString() {
		return "DruirdDateDetails [intervalDate=" + intervalDate + ", granularityIntervalDate="
				+ granularityIntervalDate + "]";
	}
}