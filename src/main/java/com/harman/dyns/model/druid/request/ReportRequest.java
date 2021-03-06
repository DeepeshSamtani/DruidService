package com.harman.dyns.model.druid.request;

import java.io.Serializable;
import java.util.Map;

import com.harman.dyns.model.common.Configuration;
import com.harman.dyns.model.common.Pagination;
import com.harman.dyns.model.common.Rules;

public class ReportRequest implements Serializable {
	/**
	 */
	private static final long serialVersionUID = -4855407669924208756L;

	private Configuration configuration;
	private Rules filter;
	private String samplingPeriod;
	private String intervals;
	private Pagination pagination;
	private String granularity;
	private String reportDataType;
	private Map<String,Object> filterMap;
	
	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Rules getFilter() {
		return filter;
	}

	public void setFilter(Rules filter) {
		this.filter = filter;
	}

	public String getSamplingPeriod() {
		return samplingPeriod;
	}

	public void setSamplingPeriod(String samplingPeriod) {
		this.samplingPeriod = samplingPeriod;
	}

	public String getIntervals() {
		return intervals;
	}

	public void setIntervals(String intervals) {
		this.intervals = intervals;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	
	public String getReportDataType() {
		return reportDataType;
	}

	public void setReportDataType(String reportDataType) {
		this.reportDataType = reportDataType;
	}

	public Map<String, Object> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(Map<String, Object> filterMap) {
		this.filterMap = filterMap;
	}

	@Override
	public String toString() {
		return "ReportRequest [configuration=" + configuration + ", filter=" + filter + ", samplingPeriod="
				+ samplingPeriod + ", intervals=" + intervals + ", pagination=" + pagination + ", granularity="
				+ granularity + ", reportDataType=" + reportDataType + ", filterMap=" + filterMap + "]";
	}
	
	

	

}
