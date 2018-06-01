package com.harman.dyns.model.druid.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.harman.dyns.constant.AggregationEnum;
import com.harman.dyns.constant.Constants;
import com.harman.dyns.model.common.Metric;
import com.harman.dyns.model.druid.common.Aggregations;
import com.harman.dyns.model.druid.common.Context;
import com.harman.dyns.model.druid.common.Filter;
import com.harman.dyns.model.druid.common.PostAggregations;
import com.harman.dyns.util.DruidRequestHelper;
import com.harman.dyns.util.FilterHelper;

public class DruidRequest extends DruidBaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3777697603687103094L;
	public static Map<String, String> druidAggregationMap = new HashMap<String, String>();
	static {
		//For druid build jar changes 
		/*druidAggregationMap.put("SUM", "doubleSumExtended");
		druidAggregationMap.put("MIN", "doubleMinExtended");
		druidAggregationMap.put("MAX", "doubleMaxExtended");
		druidAggregationMap.put("SUM_COUNT", "sum");
		druidAggregationMap.put("COUNT", "count");
		druidAggregationMap.put("AVG", "doubleSumExtended");*/
		
		druidAggregationMap.put("SUM", "doubleSum");
		druidAggregationMap.put("MIN", "doubleMin");
		druidAggregationMap.put("MAX", "doubleMax");
		druidAggregationMap.put("SUM_COUNT", "sum");
		druidAggregationMap.put("COUNT", "count");
		druidAggregationMap.put("AVG", "doubleSum");
		
	}

	private List<Aggregations> aggregations;
	private List<PostAggregations> postAggregations;
	private Filter filter;
	private Context context;

	protected DruidRequest(DruidBaseRequestBuilder druidBaseRequestBuilder, DruidRequestBuilder druidRequestBuilder) {
		super(druidBaseRequestBuilder);
		this.aggregations = druidRequestBuilder.aggregations;
		this.postAggregations = druidRequestBuilder.postAggregations;
		this.filter = druidRequestBuilder.filter;
		this.context = druidRequestBuilder.context;
	}

	public List<Aggregations> getAggregations() {
		return aggregations;
	}

	public Filter getFilter() {
		return filter;
	}

	public List<PostAggregations> getPostAggregations() {
		return postAggregations;
	}

	public Context getContext() {
		return context;
	}

	public static class DruidRequestBuilder {
		private List<Aggregations> aggregations = new ArrayList<>();
		private List<PostAggregations> postAggregations = new ArrayList<>();
		private Filter filter;
		private DruidBaseRequestBuilder baseRequestBuilder;
		private Context context;

		public DruidRequestBuilder(DruidBaseRequestBuilder druidBaseRequestBuilder, ReportRequest reportrequest) {
			this.baseRequestBuilder = druidBaseRequestBuilder;
			if (null != reportrequest && null != reportrequest.getConfiguration()
					&& (null != reportrequest.getConfiguration().getMetrics() || null != reportrequest.getConfiguration().getKpiMetrics())) {
				List<Metric> metrics = new ArrayList<>();
				if(null != reportrequest.getConfiguration().getMetrics())
					metrics.addAll(reportrequest.getConfiguration().getMetrics());
				if(null != reportrequest.getConfiguration().getKpiMetrics())
					metrics.addAll(reportrequest.getConfiguration().getKpiMetrics());
				
				metrics.forEach((metric) -> {
					//System.out.println(metric.getAggregationType());
					if (AggregationEnum.AVERAGE.getValue().equalsIgnoreCase(metric.getAggregationType())) {

						/*
						 * For EE NPM groupBy requirement 1)If Raw -> No post
						 * aggregation required & aggregation on metrics(druid
						 * datatype : doubleSum) 2)If hourly -> Post aggregation
						 * for avg metric = metric datatype:doubleSum &
						 * count_metric(count) datatype : count 3)If daily,
						 * weekly, monthly, yearly -> Post aggregation for avg
						 * metric = metric datatype:doubleSum &
						 * count_metric(count):sum
						 */

						if (null != reportrequest.getGranularity() && !reportrequest.getGranularity().isEmpty() 
								&& reportrequest.getReportDataType().equalsIgnoreCase(Constants.GROUPED)) {
							// if
							// (!(reportrequest.getGranularity().equalsIgnoreCase(Constants.All)))
							// {
							PostAggregations postAggration = null;
							String countName = new String();
							if (reportrequest.getGranularity().equalsIgnoreCase(Constants.All)) {
								if(reportrequest.getConfiguration().getMultipleAggregationsOnRawGranularity()) {
									countName = Constants.COUNT.toUpperCase() + Constants.UnderScore + metric.getId();
									Aggregations countAggregation = new Aggregations.AggregationsBuilder(Constants.COUNT,
											countName, metric.getId()).build();
									this.aggregations.add(countAggregation);
									
								} else {
									countName = metric.getId();
								}
							} else{
								String counterName = metric.getId();
								if(counterName.contains("SUM_"))
									counterName = counterName.replaceAll("SUM_", "");
								countName = Constants.COUNT.toUpperCase() + Constants.UnderScore + counterName;
							}
							
							postAggration = new PostAggregations.PostAggregationsBuilder(Constants.ARITHMETIC,
									metric.getId(), Constants.Divide, countName).build();

							this.postAggregations.add(postAggration);
							/*Aggregations countAggregation = null;
							if (reportrequest.getGranularity().equalsIgnoreCase(Constants.hourly)
									|| reportrequest.getGranularity().equalsIgnoreCase(Constants.All)) {
								countAggregation = new Aggregations.AggregationsBuilder(Constants.COUNT,
										Constants.COUNT + Constants.UnderScore + metric.getId(),
										Constants.COUNT + Constants.UnderScore + metric.getId()).build();
							} else {
								countAggregation = new Aggregations.AggregationsBuilder(Constants.SUM,
										Constants.COUNT + Constants.UnderScore + metric.getId(), null).build();
							}*/
							// this.aggregations.add(countAggregation);
							// }

							Aggregations sumAggregation = new Aggregations.AggregationsBuilder(Constants.DoubleSum,
									metric.getId(), metric.getId()).build();
							
							

							this.aggregations.add(sumAggregation);
						}
					} else {
						if (null != metric.getAggregationType() && !metric.getAggregationType().isEmpty()) {							
							String druidAggregation = druidAggregationMap.get(metric.getAggregationType().toUpperCase());
							String outputMetricName = metric.getId();
							if(reportrequest.getConfiguration().getMultipleAggregationsOnRawGranularity()) {
								outputMetricName = metric.getAggregationType().toUpperCase().concat(Constants.UnderScore).concat(outputMetricName);
							}
							Aggregations aggregation = new Aggregations.AggregationsBuilder(druidAggregation,
									outputMetricName, metric.getId()).build();
							this.aggregations.add(aggregation);
						}
					}
				});

			}
			this.filter = FilterHelper.getFilter(reportrequest.getFilter());

			this.context = DruidRequestHelper.getContext(reportrequest.getConfiguration().getContext());
		}

		public DruidRequest build() {
			return new DruidRequest(baseRequestBuilder, this);
		}

	}

}
