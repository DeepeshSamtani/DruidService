package com.harman.harmannpm.indexing.model;

public class IoConfig {
	private Firehose firehose;

    private String type;

    public Firehose getFirehose ()
    {
        return firehose;
    }

    public void setFirehose (Firehose firehose)
    {
        this.firehose = firehose;
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
        return "ClassPojo [firehose = "+firehose+", type = "+type+"]";
    }

}
