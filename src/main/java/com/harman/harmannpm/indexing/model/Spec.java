package com.harman.harmannpm.indexing.model;

public class Spec {
	private IoConfig ioConfig;

	private DataSchema dataSchema;

	public IoConfig getIoConfig() {
		return ioConfig;
	}

	public void setIoConfig(IoConfig ioConfig) {
		this.ioConfig = ioConfig;
	}

	public DataSchema getDataSchema() {
		return dataSchema;
	}

	public void setDataSchema(DataSchema dataSchema) {
		this.dataSchema = dataSchema;
	}

	@Override
	public String toString() {
		return "ClassPojo [ioConfig = " + ioConfig + ", dataSchema = " + dataSchema + "]";
	}

}
