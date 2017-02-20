package org.olixtech.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemo {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotions(@MatrixParam("param") String matrix, 
			@HeaderParam("authSessionID") String header, @CookieParam("name") String cookie){
		return "Test";
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, 
			@Context HttpHeaders headers){
		String fullpath = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		
		return "path: " + fullpath + " " + "cookies: " + cookies;
	}
}
