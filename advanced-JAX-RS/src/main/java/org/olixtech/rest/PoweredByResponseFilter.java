package org.olixtech.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/*
 * This is an example on how to create filter (in our case the response filter)
 * When creating a response filter the class has to implement the ContainerResponseFilter interface
 * Notice we can access both the ContainerRequestContext (specific for the request filters) 
 * and the ContainerResponseContext because the response filter is ran after the request 
 * was already made and is about to be serviced*/

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("X-Powered By", "OlixTech");
	}
}
