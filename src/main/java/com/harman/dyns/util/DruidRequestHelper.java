package com.harman.dyns.util;

import org.apache.commons.lang.RandomStringUtils;

import com.harman.dyns.constant.SamplingPeriodType;
import com.harman.dyns.model.druid.common.Context;
import com.harman.dyns.model.druid.common.Filter;

public class DruidRequestHelper {

	private static DruidRequestHelper instance = null;

	private static FilterHelper filterHelper = null;

	private DruidRequestHelper() {
	}

	/**
	 * 
	 * @return
	 */
	public static DruidRequestHelper getInstance() {
		if (null == instance) {
			synchronized (DruidRequestHelper.class) {
				if (null == instance) {
					instance = new DruidRequestHelper();
					filterHelper = FilterHelper.getInstance();
				}
			}
		}
		return instance;
	}

	public static String fetchUnitFromSamplingPeriod(String samplingPeriod) {
		samplingPeriod = samplingPeriod.toLowerCase();
		if (samplingPeriod.contains("second"))
			return "second";
		else if (samplingPeriod.contains("minute"))
			return "minute";
		else if (samplingPeriod.contains("hour"))
			return "hour";
		else if (samplingPeriod.contains("day"))
			return "day";
		else if (samplingPeriod.contains("week"))
			return "week";
		else if (samplingPeriod.contains("month"))
			return "month";
		else if (samplingPeriod.contains("quarter"))
			return "quarter";
		else if (samplingPeriod.contains("year"))
			return "year";
		else if (samplingPeriod.contains("all"))
			return "all";

		return samplingPeriod;
	}

	public static String fetchDruidUnitFromSamplingPeriod(String samplingPeriod) {
		samplingPeriod = samplingPeriod.toLowerCase();

		if (samplingPeriod.contains("second"))
			return "second";
		else if (samplingPeriod.contains("15 minutes"))
			return samplingPeriod;
		else if (samplingPeriod.contains("30 minutes"))
			return samplingPeriod;
		else if (samplingPeriod.contains("minute"))
			return "minute";
		else if (samplingPeriod.contains("hour"))
			return "hour";
		else if (samplingPeriod.contains("day"))
			return "day";
		else if (samplingPeriod.contains("week"))
			return "week";
		else if (samplingPeriod.contains("month"))
			return "month";
		else if (samplingPeriod.contains("quarter"))
			return "quarter";
		else if (samplingPeriod.contains("year"))
			return "year";
		else if (samplingPeriod.contains("all"))
			return "all";

		return samplingPeriod;
	}

	public String fetchDataSourceName(Filter filter) {
		return null;
	}

	public static String getSamplingPeriodType(String samplingPeriod) {
		return SamplingPeriodType.fromString(samplingPeriod);
	}

	public static Context getContext(Context context) {
		if (null == context)
			context = new Context();

		if (null == context.getTimeout()) {
			// set timeOut in millisec
			// now it is null
			// context.setTimeout(900000L); //for 15 min
		}
		if (null == context.getQueryPriority()) {
			// set default priority if you want
			// now it is null
		}
		if (null == context.getQueryId()) {
			String generatedQueryId = RandomStringUtils.randomAlphanumeric(10);
			context.setQueryId(generatedQueryId);
		}
		return context;
	}

}