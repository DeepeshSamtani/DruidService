package com.harman.dyns.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.harman.dyns.constant.Constants;
import com.harman.dyns.model.common.Rule;
import com.harman.dyns.model.common.Rules;
import com.harman.dyns.model.druid.common.Fields;
import com.harman.dyns.model.druid.common.Filter;

public class FilterHelper {
	public static Map<String, String> expressionsMap = new HashMap<String, String>();
	public static Map<String, String> druidFilterTypeMap = new HashMap<String, String>();
	static {
		expressionsMap.put("AND", "and");
		expressionsMap.put("OR", "or");
		expressionsMap.put(">", "greaterThan");
		expressionsMap.put("equal", "selector");
		expressionsMap.put("<", "lessThan");
		expressionsMap.put("!", "not");
		expressionsMap.put(">=", "greaterThanEqual");
		expressionsMap.put("<=", "LessThanEqual");
		expressionsMap.put("in", "in");
		expressionsMap.put("SELECTOR", "selector");
		expressionsMap.put("not", "not");
		druidFilterTypeMap.put("javascript", "javascript");
		druidFilterTypeMap.put("selector", "selector");
		druidFilterTypeMap.put("not", "not");
		druidFilterTypeMap.put("bound", "bound");
		

	}

	private static FilterHelper instance = null;

	private FilterHelper() {
	}

	/**
	 * 
	 * @return
	 */
	public static FilterHelper getInstance() {
		if (null == instance) {
			synchronized (FilterHelper.class) {
				if (null == instance) {
					instance = new FilterHelper();
				}
			}
		}
		return instance;
	}

	private static void replaceFilterTypeForDruidQuery(List<Rule> p_rules, List<Fields> p_fields) {
		if (null != p_rules && !p_rules.isEmpty()) {
			p_rules.forEach((rule) -> {
				Fields field = new Fields();
				if (null != rule.getCondition() && !rule.getCondition().isEmpty()) {
					if (null != p_fields) {
						field.setType(expressionsMap.get(rule.getCondition()));
						field.setFields(new ArrayList<Fields>());
						p_fields.add(field);
						
					}
				} else {
					field.setType(druidFilterTypeMap.get(rule.getType()));
					if (rule.getType().equals(Constants.Selector)) {
						field.setValue(rule.getValue());
						field.setDimension(rule.getField());
					}else if (rule.getType().equals(Constants.JavaScript)) {
						field.setFunction(rule.getValue());
						field.setDimension(rule.getId());
					}else if(rule.getType().equals(Constants.Not)){
						Fields fieldinner = new Fields();
						fieldinner.setType(rule.getRule().getType());
						fieldinner.setValue(rule.getRule().getValue());
						fieldinner.setDimension(rule.getRule().getField());
						//field.setField(fieldinner);
					}else if(rule.getType().equals(Constants.Bound)){
						field.setDimension(rule.getId());
						field.setLower(rule.getValue());
						field.setOrdering("numeric");
						field.setLowerStrict(true);
					}
					//System.out.println("fields : "+field);
					//System.out.println("p_fields : "+p_fields);
					if (null != field && null!=p_fields)
						p_fields.add(field);
						
				}
				List<Rule> l_rules = rule.getRules();
				if (null != l_rules && !l_rules.isEmpty()) {
					//System.out.println("p_rules : "+rule.getRules());
					//System.out.println("p_fields : "+field.getFields());
					replaceFilterTypeForDruidQuery(rule.getRules(), field.getFields());
				}
			});
		}
	}

	public static Filter getFilter(Rules p_rules) {
		Filter filter = null;
		if (null != p_rules && null != p_rules.getRules() && !p_rules.getRules().isEmpty()) {
			filter = new Filter();
			filter.setType(expressionsMap.get(p_rules.getCondition()));
			List<Fields> fields = new ArrayList<>();
			List<Rule> l_rules = p_rules.getRules();
			if (null != l_rules && !l_rules.isEmpty()) {
				replaceFilterTypeForDruidQuery(l_rules, fields);
			}
			filter.setFields(fields);
		}
		return filter;
	}

}