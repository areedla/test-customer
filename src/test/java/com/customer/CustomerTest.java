package com.customer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.customer.domain.Customer;
import com.customer.service.CustomerService;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest extends TestCase {
	
	 private Customer testCustomer;
	
	 @Before
	 public void setUp() throws Exception {
		 
		 testCustomer = new Customer();
		 testCustomer.setId((long) 7);
		 testCustomer.setUserName("kala");
	 }

	
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
	 public void testGetCustomerById(){ 
		 
		 //TODO: mock entityManager
		 
		 CustomerService mockService = mock(CustomerService.class);

		 when(mockService.getCustomer((long) 7)).thenReturn(testCustomer);
		 
		 Customer resultCustomer = mockService.getCustomer((long) 7);
		 assertNotNull(resultCustomer);
		 assertEquals("kala", resultCustomer.getUserName());
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
	 
	 @After
	 public void tearDown() throws Exception {
	 }
}
