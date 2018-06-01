package com.harman.dyns.model.common;

import java.io.Serializable;
import java.util.List;

import com.harman.dyns.model.druid.common.Context;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Configuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -696378756782020756L;

	/**
	 * true if multiple aggregations are required to be applied on same counter for RAW data, false otherwise
	 * It's used only in case of GROUPED report type.
	 */
	@JsonProperty(value="multipleaggsonraw", required=false, defaultValue = "false")
	private boolean multipleAggregationsOnRawGranularity;
	
	@JsonProperty(value="singleBucketResponse", required=false, defaultValue = "false")
	private boolean singleBucketResponse;
	

	private List<Attribute> attributes;
	private List<Attribute> properties;
	private List<Metric> metrics;
	private List<Metric> kpiMetrics;
	private String name;
	private String type;
	private String subType;
	private String deviceType;
	private Attribute entity;
	private List<Attribute> dimensions;
	private Context context;
	private List<String> groupByDimensions;

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Attribute> getProperties() {
		return properties;
	}

	public void setProperties(List<Attribute> properties) {
		this.properties = properties;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public List<Metric> getKpiMetrics() {
		return kpiMetrics;
	}

	public void setKpiMetrics(List<Metric> kpiMetrics) {
		this.kpiMetrics = kpiMetrics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Attribute getEntity() {
		return entity;
	}

	public void setEntity(Attribute entity) {
		this.entity = entity;
	}

	public List<Attribute> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Attribute> dimensions) {
		this.dimensions = dimensions;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public List<String> getGroupByDimensions() {
		return groupByDimensions;
	}

	public void setGroupByDimensions(List<String> groupByDimensions) {
		this.groupByDimensions = groupByDimensions;
	}
	
	/**
	 * @return the multipleAggregationsOnRawGranularity
	 */
	public boolean getMultipleAggregationsOnRawGranularity() {
		return multipleAggregationsOnRawGranularity;
	}

	/**
	 * @param multipleAggregationsOnRawGranularity the multipleAggregationsOnRawGranularity to set
	 */
	public void setMultipleAggregationsOnRawGranularity(boolean multipleAggregationsOnRawGranularity) {
		this.multipleAggregationsOnRawGranularity = multipleAggregationsOnRawGranularity;
	}

	/**
	 * @return the singleBucketResponse
	 */
	public boolean getSingleBucketResponse() {
		return singleBucketResponse;
	}

	/**
	 * @param singleBucketResponse the singleBucketResponse to set
	 */
	public void setSingleBucketResponse(boolean singleBucketResponse) {
		this.singleBucketResponse = singleBucketResponse;
	}

	@Override
	public String toString() {
		return "Configuration [attributes=" + attributes + ", properties=" + properties + ", metrics=" + metrics
				+ ", kpiMetrics=" + kpiMetrics + ", name=" + name + ", type=" + type + ", subType=" + subType
				+ ", deviceType=" + deviceType + ", entity=" + entity + ", dimensions=" + dimensions + ", context="
				+ context + ", groupByDimensions=" + groupByDimensions + "]";
	}

}
