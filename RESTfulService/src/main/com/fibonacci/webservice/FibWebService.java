package com.fibonacci.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fibonacci.service.FibService;

@Path("/fibonacci")
public class FibWebService {
/**
 * Captures GET request 
 * @param number
 * @return Response
 * @throws Exception
 */
	@Path("/number{number:(/[^/]+?)?}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnFibonacci(
			@PathParam("number") String number) 
					throws Exception {

		Response response;
		FibService fibService = new FibService();
		try{
			response = fibService.getFibonacci(number);
		} catch(Exception e){
			return Response.status(500).entity("Internal Server Error").build();
		}
		return response;
	}
}


