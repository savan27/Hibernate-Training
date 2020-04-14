/**
 * 
 */
package com.savan.model;

/**
 * @author SAVAN
 *
 */
public class UserModel {
	
	private int id;
	private String firstname;
	private String lastname;
	
	/**
	 * @param firstname
	 * @param lastname
	 */
	public UserModel( String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	/**
	 * Default Constructor
	 */
	public UserModel() {
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
