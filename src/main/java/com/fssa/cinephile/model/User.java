package com.fssa.cinephile.model;

/**
 * The {@code User} class represents a user entity in the application. It
 * includes information about the user's email, password, first name, last name,
 * and phone number.
 * 
 * @author UtchikannaNeelakanda
 */
public class User {

	

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ "]";
	}

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private long phoneNo;
	private int userId;
	
	

	/**
	 * Constructs a new {@code User} object with the provided information.
	 *
	 * @param email     The email of the user.
	 * @param password  The password of the user.
	 * @param firstName The first name of the user.
	 * @param lastName  The last name of the user.
	 * @param phoneNo   The phone number of the user.
	 */
	public User(String email, String password, String firstName, String lastName, long phoneNo) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		
	}
	
	/**
	 * Constructs a new User object with the specified attributes.
	 *
	 * @param email The email address of the user.
	 * @param password The password associated with the user's account.
	 * @param firstName The first name of the user.
	 * @param lastName The last name of the user.
	 * @param phoneNo The phone number of the user.
	 * @param userId The unique identifier of the user.
	 */
	public User(String email, String password, String firstName, String lastName, long phoneNo, int userId) {
	    this.email = email;
	    this.password = password;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phoneNo = phoneNo;
	    this.userId = userId;
	}


	/**
	 * Constructs a new {@code User} object with the provided email and password.
	 *
	 * @param email    The email of the user.
	 * @param password The password of the user.
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User() {
		
	}

	public User(long phoneNo ,int userId, String lastName, String firstName) {
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.phoneNo = phoneNo;	
	    this.userId = userId;
	}
   public User(String email,String firstName,String lastName, long phoneNo) {
	this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNo = phoneNo;
    this.email = email;
   }


	/**
	 * Retrieves the first name of the user.
	 *
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 *
	 * @param firstName The first name of the user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of the user.
	 *
	 * @return The last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 *
	 * @param lastName The last name of the user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the phone number of the user.
	 *
	 * @return The phone number of the user.
	 */
	public long getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone number of the user.
	 *
	 * @param phoneNo The phone number of the user.
	 */
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Sets the email of the user.
	 *
	 * @param email The email of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieves the email of the user.
	 *
	 * @return The email of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retrieves the password of the user.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * Retrieves the user's unique identifier.
	 *
	 * @return An integer representing the user's unique identifier.
	 */
	public int getUserId() {
	    return userId;
	}

	/**
	 * Sets the user's unique identifier.
	 *
	 * @param userId An integer representing the unique identifier of the user to be set.
	 */
	public void setUserId(int userId) {
	    this.userId = userId;
	}

}
