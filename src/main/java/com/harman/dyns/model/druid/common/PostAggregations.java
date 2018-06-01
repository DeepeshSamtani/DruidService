package com.harman.dyns.model.druid.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.harman.dyns.constant.Constants;
import com.harman.dyns.validator.Preconditions;

public class PostAggregations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3274244697746216837L;
	private String type;
	private String name;
	private String fn;
	private List<Aggregations> fields;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getFn() {
		return fn;
	}

	public List<Aggregations> getFields() {
		return fields;
	}

	private PostAggregations(PostAggregationsBuilder postAggregationBuilder) {
		this.type = postAggregationBuilder.type;
		this.name = postAggregationBuilder.name;
		this.fn = postAggregationBuilder.fn;
		this.fields = postAggregationBuilder.fields;
	}

	public static class PostAggregationsBuilder {
		private String type;
		private String name;
		private String fn;
		private List<Aggregations> fields = new ArrayList<>();

		public PostAggregationsBuilder(String type, String name, String fn, String countName) {
			String countCounterName = name;
			if(name.contains("SUM_"))
				countCounterName = countCounterName.replaceAll("SUM_", "");
			
			this.type = Preconditions.checkNotNull(type, "Aggreation Type must not be null");
			this.name = Preconditions.checkNotNull( Constants.Average+Constants.UnderScore+countCounterName, "Aggreation Name must not be null");
			this.fn = fn;
			//(type,name,fieldName)
			Aggregations aggregation1 = new Aggregations.AggregationsBuilder(Constants.fieldAccess,
					name , name )
							.build();
			
			Aggregations aggregation2 = new Aggregations.AggregationsBuilder(Constants.fieldAccess,
					Constants.COUNT.toUpperCase() + Constants.UnderScore + countCounterName , countName  ).build();
			fields.add(aggregation1);
			fields.add(aggregation2);

		}

		public PostAggregations build() {
			return new PostAggregations(this);
		}
	}

}
