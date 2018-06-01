package com.harman.harmannpm.indexing.model;

import java.util.Arrays;

public class Firehose {

	private String dataSource;

	private String interval;

	private String[] metrics;

	private String[] dimensions;

	private String type;

	private Filter filter;

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String[] getMetrics() {
		return metrics;
	}

	public void setMetrics(String[] metrics) {
		this.metrics = metrics;
	}

	public String[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(String[] dimensions) {
		this.dimensions = dimensions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "Firehose [dataSource=" + dataSource + ", interval=" + interval + ", metrics=" + Arrays.toString(metrics)
				+ ", dimensions=" + Arrays.toString(dimensions) + ", type=" + type + ", filter=" + filter + "]";
	}
}
