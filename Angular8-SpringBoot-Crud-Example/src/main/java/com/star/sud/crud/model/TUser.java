/**
 * 
 */
package com.star.sud.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudarshan
 *
 */
@Entity
@Table(name = "T_USERS")
public class TUser {

	// Attributes
	//////////////////
	private long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String place;

	// Constructors
	//////////////////
	public TUser() {
		
	}
	
	public TUser(String firstName, String lastName, String emailId, String place) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.place = place;
	}

	// Override Methods
	//////////////////////
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", place=" + place + "]";
	}

	// Properties
	////////////////
	/**
	 * @return the userId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "LAST_NAME", nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	@Column(name = "EMAIL_ID", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the place
	 */
	@Column(name = "PLACE")
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

}
