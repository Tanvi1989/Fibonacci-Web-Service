package com.fibonacci.webservice;


import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fibonacci.app.AppMain;
import com.fibonacci.data.Fibonacci;

public class FibWebServiceTest {

	/**
	 * Starting server from AppMain Class
	 */
	@BeforeClass
	public static void BeforeClass(){
		AppMain.main(new String[]{});
	}

/**
 * testing the response of
 * GET request for positive parameter
 */
	@Test
	public void positiveResultsTest(){
		
		String request = "http://localhost:8080/RESTfulService/api/fibonacci/number/3";

		try {
			
			URL url = new URL(request);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			assertTrue(conn.getResponseCode() == 200);
			//System.out.println(conn.getResponseCode());
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			JSONParser parser = new JSONParser();
			//JSONArray jArray=null;
			String output;
			Object obj=null;
			JSONObject jObj=null;
			//Response is a JSON Array
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				obj = parser.parse(output);
				jObj = (JSONObject) obj;
			}
			
			String data = jObj.get("data").toString();
			
			String values = Fibonacci.getFibonacci("3");
			assertTrue(values.equals(data));
			
		}
		catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * testing the status code of
     * GET request for negative parameter
	 * @throws Exception
	 */

	@Test
	public void negativeResultsTest() throws Exception{
		
		String request = "http://localhost:8080/RESTfulService/api/fibonacci/number/-3";
		HttpURLConnection conn = null;
		try {
			
			URL url = new URL(request);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			assertTrue(conn.getResponseCode() != 200);
			
		}
		catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	/**
	 * testing the status code of
     * GET request when parameter Not A Number
	 * @throws Exception
	 */

	@Test
	public void NaNTest() throws Exception{
		
		String request = "http://localhost:8080/RESTfulService/api/fibonacci/number/abc12";
		HttpURLConnection conn = null;
		try {
			
			URL url = new URL(request);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			assertTrue(conn.getResponseCode() != 200);
			
		}
		catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stopping the Server
	 */
	@AfterClass
	public static void AfterClass(){
		AppMain.end();
	}
}
