package com.harman.dyns.model.druid.common;

import com.harman.dyns.model.druid.request.DruidBaseRequest;

public class RequestObject {
	private String url;
	private DruidBaseRequest druidBaseRequest;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DruidBaseRequest getDruidBaseRequest() {
		return druidBaseRequest;
	}

	public void setDruidBaseRequest(DruidBaseRequest druidBaseRequest) {
		this.druidBaseRequest = druidBaseRequest;
	}
}