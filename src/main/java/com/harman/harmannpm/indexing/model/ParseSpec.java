package com.harman.harmannpm.indexing.model;

public class ParseSpec {

	private TimestampSpec timestampSpec;

    private DimensionsSpec dimensionsSpec;

    private String format;

    public TimestampSpec getTimestampSpec ()
    {
        return timestampSpec;
    }

    public void setTimestampSpec (TimestampSpec timestampSpec)
    {
        this.timestampSpec = timestampSpec;
    }

    public DimensionsSpec getDimensionsSpec ()
    {
        return dimensionsSpec;
    }

    public void setDimensionsSpec (DimensionsSpec dimensionsSpec)
    {
        this.dimensionsSpec = dimensionsSpec;
    }

    public String getFormat ()
    {
        return format;
    }

    public void setFormat (String format)
    {
        this.format = format;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestampSpec = "+timestampSpec+", dimensionsSpec = "+dimensionsSpec+", format = "+format+"]";
    }

}
