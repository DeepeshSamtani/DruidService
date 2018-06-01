package com.harman.dyns.constant;

public interface Constants {

	// DB Type Constants
	public static String Druid = "druid";
	public static String Mysql = "mysql";

	// Operator Constant
	public static String TrueString = "true";
	public static String FALSE = "false";
	public static String Divide = "/";
	public static String Average = "AVG";
	public static String ROWS = "rows";
	public static String COUNT = "count";
	public static String ARITHMETIC = "arithmetic";
	public static String AVG = "avg";
	public static String fieldAccess = "fieldAccess";
	public static String DoubleSum = "doubleSum";
	public static String DoubleMin = "doubleMin";
	public static String DoubleMax = "doubleMax";
	public static String UnderScore = "_";
	public static String Total = "tot";
	public static String MIN = "Min";
	public static String MAX = "Max";
	public static String Not = "not";
	public static String SUM = "sum";
	
	// report type
	public static String TABLE = "Table";
	public static String TABLE_REAL_TIME = "Table_real_time";

	// filter type
	public static String JavaScript = "javascript";
	public static String Selector = "selector";
	public static String Bound = "bound";

	// Aggregation type
	public static String All = "ALL"; //Raw datasource
	public static String hourly = "HOURLY";
	public static String daily = "DAILY";
	public static String weekly = "WEEKLY";
	public static String monthly = "MONTHLY";
	
	//UI query Type
	public static String GROUPED = new String("grouped"); // groupBy query
	public static String RAW = new String("raw"); // select query
}
