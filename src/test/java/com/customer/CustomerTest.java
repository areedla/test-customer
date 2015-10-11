package com.customer;

import java.util.Date;

import org.junit.Test;

import com.customer.domain.Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	 @Test
	 public void testIfTestIsWorking() {
		 
		 assertEquals(9, 9);
		 //System.out.println("Yes, it works!");
	 }
	 
	 @Test
	 public void testCustomerAttributes() {
		 
		 Customer customer = new Customer();
		 customer.setFirstName("first");
		 customer.setLastName("last");
		 customer.setPassword("hidden");
		 customer.setUserName("testuser");
		 customer.setDateOfBirth(new Date(105, 11, 9)); // i now deprecated constructor
		 
		 assertEquals("first", customer.getFirstName());
		 assertEquals("last", customer.getLastName());
		 assertEquals("hidden", customer.getPassword());
		 assertEquals("testuser", customer.getUserName());
		 assertEquals("09.12.2005", customer.getDateOfBirthString());
	 }
	 
	 @Test
	 public void testCustomerConstraints() {
		 //TODO: test constrains in entity Customer
		 assertTrue(true);
	 }
	 
	 @Test
	 public void testSaveEditAndDeleteAnd() {
		 
		 //TODO: mock and test service methods (use Mockito or ..)
		 assertTrue(true);
	 }
	 
	 @Test
	 public void testSomtingMore() {
		 //TODO:
		 assertTrue(true);
	 }
}
