package com.fssa.cinephile.model;

/**
 * The {@code User} class represents a user entity in the application.
 * It includes information about the user's email, password, first name, last name, and phone number.
 * 
 * @author UtchikannaNeelakanda
 */
public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNo;
    private int user_id;

    /**
     * Constructs a new {@code User} object with the provided information.
     *
     * @param email     The email of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param phoneNo   The phone number of the user.
     */
    public User(String email, String password, String firstName, String lastName, int phoneNo) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
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
		// TODO Auto-generated constructor stub
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
    public int getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNo The phone number of the user.
     */
    public void setPhoneNo(int phoneNo) {
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

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo + "]";
    }

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
}
