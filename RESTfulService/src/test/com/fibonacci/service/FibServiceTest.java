package com.fibonacci.service;

import static org.junit.Assert.*;
import org.codehaus.jettison.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.ws.rs.core.Response;

public class FibServiceTest {

	private static FibService service = null;
	@BeforeClass
	public static void BeforeClass(){
		service =  new FibService();
	}
	/**
	 * Checking response status for small values of path parameter
	 */
	@Test
	public void SmallValueReturnTest() {
		try {
			Response response = service.getFibonacci("/10");
			assertTrue(response.getStatus() == 200);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Checking response status for relatively large values of path parameters
	 */
	@Test
	public void LargeValueReturnTest() {	
		try {
			Response response = service.getFibonacci("/80");
			assertTrue(response.getStatus() == 200);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checking response for negative values of path parameters
	 */
	@Test
	public void negativeTest() {
		try {
			Response response = service.getFibonacci("/-1");
			assertTrue(response.getStatus() == 400);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checking response for null path parameter
	 */
	@Test
	public void nullTest() {
		try {
			Response response = service.getFibonacci(null);
			assertTrue(response.getStatus() == 400);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
