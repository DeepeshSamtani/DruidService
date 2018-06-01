package com.harman.dyns.model.druid.request;

import java.util.List;

import com.harman.dyns.constant.Constants;
import com.harman.dyns.model.common.Attribute;
import com.harman.dyns.model.common.Metric;
import com.harman.dyns.model.druid.common.PagingSpec;

public class DruidSelectRequest extends DruidRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2972429363998388520L;

	private String[] dimensions;
	private String[] metrics;
	private PagingSpec pagingSpec;

	protected DruidSelectRequest(DruidBaseRequestBuilder baseRequestBuilder, DruidRequestBuilder druidRequestBuilder,
			SelectRequestBuilder selectRequestBuilder) {
		super(baseRequestBuilder, druidRequestBuilder);
		this.dimensions = selectRequestBuilder.dimensions;
		this.metrics = selectRequestBuilder.metrics;
		this.pagingSpec = selectRequestBuilder.pagingSpec;
	}

	public String[] getDimensions() {
		return dimensions;
	}

	public String[] getMetrics() {
		return metrics;
	}

	public PagingSpec getPagingSpec() {
		return pagingSpec;
	}

	public static class SelectRequestBuilder {
		private String[] dimensions;
		private String[] metrics;
		private PagingSpec pagingSpec;
		private DruidRequestBuilder druidRequestBuilder;
		private DruidBaseRequestBuilder baseRequestBuilder;

		public SelectRequestBuilder(DruidBaseRequestBuilder baseRequestBuilder, ReportRequest reportRequest) {

			String[] dimensions = null;
			// after need to change this code for kpi & counter report
			List<Metric> metrics = null;
			if (null != reportRequest && null != reportRequest.getConfiguration()
					&& null != reportRequest.getConfiguration().getMetrics()) {
				metrics = reportRequest.getConfiguration().getMetrics();
			} else if (null != reportRequest && null != reportRequest.getConfiguration()
					&& null != reportRequest.getConfiguration().getKpiMetrics()) {
				metrics = reportRequest.getConfiguration().getKpiMetrics();
			}

			if (null != metrics && !metrics.isEmpty()) {
				String[] druidMetrics = new String[metrics.size()];
				for (int i = 0; i < metrics.size(); i++) {
					druidMetrics[i] = metrics.get(i).getId();
				}
				this.metrics = druidMetrics;
			}
			
			if(null != reportRequest && null != reportRequest.getConfiguration().getDimensions())
			{
				String[] druiddimensions = new String[reportRequest.getConfiguration().getDimensions().size()];
				for (int i = 0; i < reportRequest.getConfiguration().getDimensions().size(); i++) {
					druiddimensions[i] = reportRequest.getConfiguration().getDimensions().get(i).getId();
				}
				dimensions = druiddimensions;
			}
			this.baseRequestBuilder = baseRequestBuilder;
			this.druidRequestBuilder = new DruidRequestBuilder(baseRequestBuilder, reportRequest);
			this.dimensions = dimensions;

			/*
			 * this.pagingSpec = new
			 * PagingSpecBuilder(reportrequest.getPagination().
			 * getPagingIdentifiers(),
			 * reportrequest.getPagination().getPagesize(),
			 * reportrequest.getPagination().getPagenumber()).build();
			 */
			PagingSpec pagingSpec = reportRequest.getPagination().getPagingSpec();
			if (null == pagingSpec) {
				pagingSpec = new PagingSpec();
				reportRequest.getPagination().setPagingSpec(pagingSpec);
			}
			pagingSpec.setThreshold(reportRequest.getPagination().getPagesize());
			this.pagingSpec = pagingSpec;
		}

		public DruidSelectRequest build() {
			return new DruidSelectRequest(baseRequestBuilder, druidRequestBuilder, this);
		}
	}

}
