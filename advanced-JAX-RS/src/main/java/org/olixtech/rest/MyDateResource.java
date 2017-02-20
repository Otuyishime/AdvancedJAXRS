package org.olixtech.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class MyDateResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String myDateString(@PathParam("dateString") MyDate myDate) {
		return "Got: " + myDate.toString();
	}
}
