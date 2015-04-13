package com.fibonacci.data;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FibonacciTest {
/**
 * Unit test to test the fibonacci function
 */
	@Test
	public void numbersReturned(){
		String values = Fibonacci.getFibonacci("6");
		ArrayList<Integer> numbers= new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(values);
		 
		while (st.hasMoreElements()) {
			numbers.add(Integer.parseInt(st.nextElement().toString()));
		}
		assertNotNull(values);
		assertTrue(numbers.size() == 6);
		System.out.println(values);
	}
	
}
