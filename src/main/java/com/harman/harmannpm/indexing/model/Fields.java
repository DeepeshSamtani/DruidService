package com.harman.harmannpm.indexing.model;

public class Fields {

	private String dimension;

    private String type;

    private String function;

    public String getDimension ()
    {
        return dimension;
    }

    public void setDimension (String dimension)
    {
        this.dimension = dimension;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getFunction ()
    {
        return function;
    }

    public void setFunction (String function)
    {
        this.function = function;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dimension = "+dimension+", type = "+type+", function = "+function+"]";
    }

}
