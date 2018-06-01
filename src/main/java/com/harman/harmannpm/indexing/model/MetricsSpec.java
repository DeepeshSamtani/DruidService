package com.harman.harmannpm.indexing.model;

public class MetricsSpec {

	 private String name;

	    private String fieldName;

	    private String type;

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getFieldName ()
	    {
	        return fieldName;
	    }

	    public void setFieldName (String fieldName)
	    {
	        this.fieldName = fieldName;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [name = "+name+", fieldName = "+fieldName+", type = "+type+"]";
	    }

}
