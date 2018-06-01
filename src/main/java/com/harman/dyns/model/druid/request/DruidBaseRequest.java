package com.harman.dyns.model.druid.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.harman.dyns.constant.Constants;
import com.harman.dyns.validator.Preconditions;

public class DruidBaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2643778473833501813L;
	private String queryType;
	private String dataSource;
	private String granularity;
	private List<String> intervals = new ArrayList<>();
	private String descending;

	public String getQueryType() {
		return queryType;
	}

	public String getDataSource() {
		return dataSource;
	}

	public String getGranularity() {
		return granularity;
	}

	public List<String> getIntervals() {
		return intervals;
	}

	public String getDescending() {
		return descending;
	}

	protected DruidBaseRequest(DruidBaseRequestBuilder druidBaseRequestBuilder) {
		this.queryType = druidBaseRequestBuilder.queryType;
		this.dataSource = druidBaseRequestBuilder.dataSource;
		this.granularity = druidBaseRequestBuilder.granularity;
		this.intervals.add(druidBaseRequestBuilder.intervals);
		this.descending = druidBaseRequestBuilder.descending;

	}

	public static class DruidBaseRequestBuilder {

		private String queryType;
		private String dataSource;
		private String granularity;
		private String intervals;
		private String descending;

		public DruidBaseRequestBuilder(String queryType, String dataSource, String granularity, String intervals) {
			this.queryType = Preconditions.checkNotNull(queryType, "Query Type must not be null");
			this.dataSource = Preconditions.checkNotNull(dataSource, "DataSource must not be null");
			this.granularity = Preconditions.checkNotNull(granularity, "Granularity must not be null");
			this.intervals = Preconditions.checkNotNull(intervals, "Interval must not be null");
			this.descending = Constants.TrueString;
		}

		public DruidBaseRequest build() {
			return new DruidBaseRequest(this);
		}

	}

}