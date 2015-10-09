 package com.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Business logic whit customer
 * @author reedlaa
 *
 */
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
	 * 
	 * @return
	 */
	public boolean saveCustomer(Long id, String firstName, String lastName, 
			String userName, String password, Date dateOfBirth){
		
		Customer custumer;
		
		try{
			if(id == null){
				custumer = new Customer();
			}else{
				custumer = (Customer) entityManager
	            	.createNamedQuery(Customer.BY_ID)
	            	.setParameter("id", id).getSingleResult();
			}
			
			custumer.setFirstName(firstName);
			custumer.setLastName(lastName);
			custumer.setUserName(userName);
			custumer.setPassword(password);
			custumer.setDateOfBirth(dateOfBirth);
			
			this.entityManager.persist(custumer);
			this.entityManager.flush();
		}
		catch(Exception e){
			
			logger.error("Error on saving custumer! " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean deleteCustomer(Long id){
		
		
		
		return true;
	}
}
