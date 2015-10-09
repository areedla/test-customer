package com.customer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.StringUtils;


/**
 * The main and the only object
 * @author reedlaa
 *
 */
@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = -7024947819054360655L;
	
	@Id
    @GeneratedValue
	private Long 	id;
	private String 	firstName;
	private String 	lastName;
	private String 	userName;
	private String 	password;
	private Date 	dateOfBirth;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Costumers full name
	 * @return firstName + lastName, else Nobody
	 */
	public String getFullName() {
		
		String fullName = "Nobody";
		
		if(!StringUtils.isEmpty(this.firstName)){
			fullName = this.firstName;
		}
		if(!StringUtils.isEmpty(this.lastName)){
			if(fullName.equals("Nobody"))
				fullName = this.lastName;
			else
				fullName += this.lastName;
		}
		
		return fullName;
	}
	
}
