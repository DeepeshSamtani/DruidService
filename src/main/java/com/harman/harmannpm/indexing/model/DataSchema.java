package com.harman.harmannpm.indexing.model;

import java.util.Arrays;

public class DataSchema {

	private GranularitySpec granularitySpec;

    private String dataSource;

    private MetricsSpec[] metricsSpec;

    private Parser parser;

	public GranularitySpec getGranularitySpec() {
		return granularitySpec;
	}

	public void setGranularitySpec(GranularitySpec granularitySpec) {
		this.granularitySpec = granularitySpec;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public MetricsSpec[] getMetricsSpec() {
		return metricsSpec;
	}

	public void setMetricsSpec(MetricsSpec[] metricsSpec) {
		this.metricsSpec = metricsSpec;
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	@Override
	public String toString() {
		return "DataSchema [granularitySpec=" + granularitySpec + ", dataSource=" + dataSource + ", metricsSpec="
				+ Arrays.toString(metricsSpec) + ", parser=" + parser + "]";
	}

}
