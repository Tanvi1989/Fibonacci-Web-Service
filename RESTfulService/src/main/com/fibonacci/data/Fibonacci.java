package com.fibonacci.data;

public class Fibonacci {
	/**
	 * Function to get first n fibonacci numbers
	 * @param n 
	 * @return string of fibonacci nummbers
	 */
	public static String getFibonacci(String n) {
		
		long num=Integer.parseInt(n);
		String retString;

		retString = "";
		if(num == 0) {
			return retString;
		}
		if(num >= 1) {
			retString = retString+"0";
		}
		if(num >=2) {
			retString+=" 1";
		}
		long a = 0;
		long b = 1;
		long c = 0;
		for(long i=2;i<num;i++) {
			c = a+b;
			a=b;
			b=c;
			if(c<0) {
				retString = "-1";
				break;
			}
			retString=retString+" "+Long.toString(c);
		}

		return retString;
	
	}

}
