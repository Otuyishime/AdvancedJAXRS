package org.olixtech.rest;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private  static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private  static final String AUTHORIZATION_HEADER_PREFIX = "Basic";

	// if you only want to secure some resources
	// In this example: /secured
	private  static final String SECURED_URL_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println(requestContext.getUriInfo().getPath().toString());
		if ( requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
			// if the client requested secured resources
			
			List<String> authHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if( authHeaders != null && authHeaders.size() > 0){
				String authToken = authHeaders.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);

				// Get the credentials
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String userName = tokenizer.nextToken();
				String passWord = tokenizer.nextToken();

				// Use simple test
				if(userName.equals("user") && passWord.equals("password")){
					return;	// Let the server proceed
				}
			}
			// If they are wrong 
			Response unAuthorizedStatus = Response
					.status(Response.Status.UNAUTHORIZED)
					.entity("User not accepted")
					.build();
			// use the response to abort the task
			requestContext.abortWith(unAuthorizedStatus);
		}
	}
}
