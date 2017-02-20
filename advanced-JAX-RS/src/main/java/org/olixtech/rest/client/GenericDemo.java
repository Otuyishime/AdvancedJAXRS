package org.olixtech.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.olixtech.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		/*
		 * This code is an example of how to return generic types from different REST API calls
		 * In our example we are returning a generic list of messages
		 * We have to pass an instance of GenericType<T> where T is the generic type we want to return*/
		
		Client client = ClientBuilder.newClient();
		List<Message> response = client.target("http://localhost:8080/advanced-JAX-RS/webapi/")
					.path("messages")
					.queryParam("year", 2016)
					.request(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Message>>(){});
		
		System.out.print(response.size());
	}

}
