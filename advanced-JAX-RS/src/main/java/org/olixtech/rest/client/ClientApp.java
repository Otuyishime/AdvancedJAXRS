package org.olixtech.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.olixtech.messenger.model.Message;

public class ClientApp {

	public static void main(String[] args) {
		
		/*
		 * This code is an example of how to make REST API calls and return JSON responses
		 * Part c is an example of how to make a POST request*/
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-JAX-RS/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessagesTarget = messagesTarget.path("{messageId}");
		
		// a)
		Response message1 = singleMessagesTarget.
				resolveTemplate("messageId", "1").
				request(MediaType.APPLICATION_JSON)
				.get();
		
		// b)
		Response message2 = singleMessagesTarget.
				resolveTemplate("messageId", "2").
				request(MediaType.APPLICATION_JSON)
				.get();
		
		// c)
		// Make a POST request
		Message newMessage = new Message("Another test message", "anotherUser");
		Response postResponse = messagesTarget
								.request()
								.post(Entity.json(newMessage));
		
		System.out.println("Message1: " + message1.readEntity(Message.class).getMessage());
		System.out.println("Message2: " + message2.readEntity(Message.class).getMessage());
		System.out.println("Added message: " + postResponse.readEntity(Message.class).getMessage());
	}
}
