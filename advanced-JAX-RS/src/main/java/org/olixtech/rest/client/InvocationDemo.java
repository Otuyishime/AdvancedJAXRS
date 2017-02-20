package org.olixtech.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.olixtech.messenger.model.Message;

public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForSingleMessage(1);
		Response response = invocation.invoke();
		System.out.println(response.readEntity(Message.class).getMessage());
	}
	
	public Invocation prepareRequestForSingleMessage(int messageId){
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/advanced-JAX-RS/webapi/")
					.path("messages")
					.queryParam("messageId", messageId)
					.request(MediaType.APPLICATION_JSON)
					.buildGet();
	}
}
