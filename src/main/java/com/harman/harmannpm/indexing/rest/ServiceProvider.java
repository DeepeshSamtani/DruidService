package com.harman.harmannpm.indexing.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServiceProvider{
	private static String druidBrokerIP;
	private static int port;
	private static String resourceURL;
	private static String requestURL;
	
	private  Client client = Client.create();

	public static void setResource(String brokerIP,int druidport, String druidResourceURL){
		druidBrokerIP=brokerIP;
		port=druidport;
		resourceURL=druidResourceURL;
		setProperties();
	}
	
	private static void setProperties() {
		requestURL = "http://" + druidBrokerIP + ":" + port + "/" + resourceURL;
	}
	
	public ClientResponse serveRequest(String queryJson) throws Exception {
		WebResource resource = client.resource(requestURL);
		return resource.type("application/json").post(ClientResponse.class, queryJson);
	}

	
}
