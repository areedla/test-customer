package com.customer;

/**
 * Costumer util methods
 * @author reedlaa
 *
 */
public class CustomerUtil {
	
	static String happinessInWords(int scale){
		
		switch(scale){
			case 1:
				return "is the way towards happiness!";
			case 2:
				return "is not yet fully sure!";
			case 3:
				return "is happy!";
			case 4:
				return "is very happy!";
			case 5:
				return "is indescribably happy!";
			default:
				return "happpiness is not measurable!";	
		}
	}
}
