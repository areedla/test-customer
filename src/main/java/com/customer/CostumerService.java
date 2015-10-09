package com.customer;

/**
 * Business logic whit customer
 * @author reedlaa
 *
 */
public class CostumerService {
	
	/**
	 * How happy is customer from 1 to 5
	 * @param scale nr. 1-5
	 * @return happiness
	 */
	public String happyCustomer(Customer customer, int scale){
		
		return customer.getFullName() + " " + CustomerUtil.happinessInWords(scale);
	}
}
