package com.harman.dyns.model.druid.common;

import java.io.Serializable;

public class Context implements Serializable {

	private Long timeout;
	private String queryId;
	private Long queryPriority;

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Long getQueryPriority() {
		return queryPriority;
	}

	public void setQueryPriority(Long queryPriority) {
		this.queryPriority = queryPriority;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
}
