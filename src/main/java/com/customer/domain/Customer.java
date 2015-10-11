package com.customer.domain;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.util.StringUtils;


/**
 * The main and the only object    
 * TODO: constraints.. a'la unique username 
 * @author reedlaa
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = Customer.GET_ALL,
            query = "SELECT e FROM Customer e"),
    @NamedQuery(
            name = Customer.BY_ID,
            query = "SELECT e FROM Customer e WHERE e.id = :id"),
})
public class Customer implements Serializable{

	private static final long serialVersionUID = -7024947819054360655L;
	
	public final static String GET_ALL = "com.customer.domain.Customer.GET_ALL";
    public final static String BY_ID = "com.customer.domain.Customer.BY_ID";
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 	id;
	private String 	firstName;
	private String 	lastName;
	@Column(nullable = false)
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
	public String getDateOfBirthString() {
		if(dateOfBirth == null) 
			return "";
		// TODO: date utils
		Format formatter = new SimpleDateFormat("dd.MM.yyyy");
		return formatter.format(dateOfBirth);
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
