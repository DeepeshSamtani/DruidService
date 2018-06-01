package com.harman.dyns.model.druid.request;

import java.io.Serializable;

import com.harman.dyns.model.common.Having;
import com.harman.dyns.model.common.LimitSpec;

public class DruidGroupByRequest  extends DruidRequest implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5381320580477449046L;
	private String[] dimensions;
	private LimitSpec limitSpec;
	private Having having;
	
	public String[] getDimensions() {
		return dimensions;
	}

	public LimitSpec getLimitSpec() {
		return limitSpec;
	}
	
	public Having getHaving() {
		return having;
	}

	private DruidGroupByRequest(DruidBaseRequestBuilder baseRequestBuilder, DruidRequestBuilder druidRequestBuilder,
			GroupByRequestBuilder groupByRequestBuilder) {
		super(baseRequestBuilder, druidRequestBuilder);
		this.dimensions = groupByRequestBuilder.dimensions;
		this.limitSpec = groupByRequestBuilder.limitSpec;
		this.having = groupByRequestBuilder.having;

	}

	public static class GroupByRequestBuilder {
		private String[] dimensions;
		private LimitSpec limitSpec;
		private Having having;
		private DruidRequestBuilder druidRequestBuilder;
		private DruidBaseRequestBuilder baseRequestBuilder;

		public GroupByRequestBuilder(DruidBaseRequestBuilder baseRequestBuilder, ReportRequest reportrequest) {
			//Build dimensions
			String[] dimensions = new String[reportrequest.getConfiguration().getGroupByDimensions().size()];
						
			this.baseRequestBuilder = baseRequestBuilder;
			this.druidRequestBuilder = new DruidRequestBuilder(baseRequestBuilder, reportrequest);
			this.dimensions = reportrequest.getConfiguration().getGroupByDimensions().toArray(dimensions);
			this.limitSpec = null;
			this.having = null;
		}

		public DruidGroupByRequest build() {
			return new DruidGroupByRequest(baseRequestBuilder, druidRequestBuilder, this);
		}
	}



}
