package com.fibonacci.app;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class AppMain {
	
	static HttpServer server;
	/**
	 * Hosting Server for testing purpose
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			server = HttpServerFactory.create("http://localhost:8080/RESTfulService/api");
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        server.start();
 
	}
	
	public static void end() {
		
		server.stop(0);
	}

}
