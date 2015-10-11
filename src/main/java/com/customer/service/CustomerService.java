 package com.customer.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.customer.CustomerUtil;
import com.customer.domain.Customer;


/**
 * Business logic whit customer
 * @author reedlaa
 *
 */
@Component
@Transactional(readOnly=false)
public class CustomerService {
	
	private final static Logger logger = LogManager.getLogger();
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	
	/**
	 * How happy is customer from 1 to 5
	 * @param scale nr. 1-5
	 * @return happiness
	 */
	public String happyCustomer(Customer customer, int scale){
		
		return customer.getFullName() + " " + CustomerUtil.happinessInWords(scale);
	}
	
	
	/**
	 * Customer by id
	 * @return
	 */
	public Customer getCustomer(Long id){
		
		return (Customer) entityManager
			.createNamedQuery(Customer.BY_ID)
			.setParameter("id", id).getSingleResult();
	}
	
	
	/**
	 * List of all customer objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(){
		
		return (List<Customer>) entityManager
			.createNamedQuery(Customer.GET_ALL).getResultList();
	}
	
	
	/**
	 * Saves new or old customer
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param dateOfBirth
	 * @return
	 */
	public String saveCustomer(Long id, String firstName, String lastName, 
			String userName, String password, Date dateOfBirth){
		
		Customer customer;
		
		try{
			if(id == null){
				customer = new Customer();
			}else{
				customer = (Customer) entityManager
	            	.createNamedQuery(Customer.BY_ID)
	            	.setParameter("id", id).getSingleResult();
			}
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setUserName(userName);
			customer.setPassword(password);
			customer.setDateOfBirth(dateOfBirth);
			
			this.entityManager.persist(customer);
			this.entityManager.flush();
			
			logger.debug("Added new customer: " + customer.getUserName());
		}
		catch(Exception e){
			
			logger.error("Error on saving customer! " + e.getMessage());
			return "Error on saving customer! " + e.getMessage();
		}
		
		return "";
	}
	
	
	/**
	 * Removing customer from database
	 * @param id
	 * @return
	 */
	public boolean deleteCustomer(Long id){
		
		try{
			Customer customer = (Customer) entityManager
	            	.createNamedQuery(Customer.BY_ID)
	            	.setParameter("id", id).getSingleResult();
		
		this.entityManager.remove(customer);
		this.entityManager.flush();
		}
		catch(Exception e){
			logger.error("Error on deleting customer! " + e.getMessage());
			return false;
		}
		
		return true;
	}
}
