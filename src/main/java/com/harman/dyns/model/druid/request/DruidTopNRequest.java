package com.harman.dyns.model.druid.request;

import java.io.Serializable;
import java.util.List;

import com.harman.dyns.model.common.Attribute;

public class DruidTopNRequest extends DruidRequest implements Serializable {

	private String dimension;
	private int threshold;
	private String metric;

	public String getDimension() {
		return dimension;
	}

	public int getThreshold() {
		return threshold;
	}

	public String getMetric() {
		return metric;
	}

	private DruidTopNRequest(DruidBaseRequestBuilder baseRequestBuilder,DruidRequestBuilder druidRequestBuilder, TopNRequestBuilder topnRequestBuilder) {
		super(baseRequestBuilder,druidRequestBuilder);
		this.dimension = topnRequestBuilder.dimension;
		this.threshold = topnRequestBuilder.threshold;
		this.metric = topnRequestBuilder.metric;
	}

	public static class TopNRequestBuilder {
		private String dimension;
		private int threshold;
		private String metric;
		private DruidRequestBuilder druidRequestBuilder;
		private DruidBaseRequestBuilder baseRequestBuilder;

		public TopNRequestBuilder(String metric, DruidBaseRequestBuilder baseRequestBuilder,
				ReportRequest reportrequest) {
			List<Attribute> dimensions = reportrequest.getConfiguration().getDimensions();
			if (null != dimensions && !dimensions.isEmpty()) {
				for (Attribute dimension : dimensions) {
					this.dimension = dimension.getId();
					break;
				}
			}
			this.baseRequestBuilder = baseRequestBuilder;
			this.druidRequestBuilder = new DruidRequestBuilder(baseRequestBuilder, reportrequest);
			this.threshold = reportrequest.getPagination().getPagesize();
			this.metric = metric;
		}

		public DruidTopNRequest build() {
			return new DruidTopNRequest(baseRequestBuilder,druidRequestBuilder, this);
		}
	}
	
}