package com.test.customer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
	private String 	lastNeme;
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
	public String getLastNeme() {
		return lastNeme;
	}
	public void setLastNeme(String lastNeme) {
		this.lastNeme = lastNeme;
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
	
}
