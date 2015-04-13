package com.fibonacci.service;

import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fibonacci.data.Fibonacci;

public class FibService {
	/**
	 * Prepares appropriate response for a web 
	 * service request based on input validation
	 * @param number
	 * @return Response
	 * @throws JSONException
	 */
	public Response getFibonacci(String number) throws JSONException {	
		String returnString = null;
	// Checking if path parameter is null
		if(number == null || number.length() == 0) {
			returnString = "Cannot GET /api/fibonacci/number/";
			return Response.status(400).entity(returnString).build();
		}
		number = number.split("/")[1];
		JSONObject obj = new JSONObject();
		try {
     //Checking for invalid parameters
			if(Integer.parseInt(number) <= 0)
			{
				obj.put("status", "error");
				obj.put("data", "");
				obj.put("message", "enter a number greater than 0");
				returnString=obj.toString();
				return Response.status(400).entity(returnString).build();
			}
			if(Integer.parseInt(number)>=1){

				
				returnString=Fibonacci.getFibonacci(number);
				if(returnString.equals("-1")) {
					obj.put("status", "error");
					obj.put("data", "");
					obj.put("messaage", "fibonacci series going out of range");
					returnString = obj.toString();
					return Response.status(400).entity(returnString).build();
				}
				else {
					obj.put("status", "success");
					obj.put("data", returnString);
					obj.put("message", "null");
				}
				
				returnString = obj.toString();
			}
		}
		catch (Exception e) {
			//e.printStackTrace();
			obj.put("status", "error");
			obj.put("data", "");
			obj.put("message", "please enter a valid value");
			returnString=obj.toString();
			return Response.status(400).entity(returnString).build();
		}

		return Response.ok(returnString).build();
		
	} 
}
