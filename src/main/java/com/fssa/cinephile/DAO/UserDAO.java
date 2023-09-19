package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with User entities in the database.
 * 
 * @author UtchikannaNeelakandan
 */
public class UserDAO {

	// Connect to database

	/**
	 * Checks if a user with the given email and password exists in the database.
	 *
	 * @param email    The email of the user to be checked.
	 * @param password The password of the user to be checked.
	 * @return True if the user exists and the provided password is correct, false
	 *         otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public User checkUserLogin(String email) throws DAOException {
		User user = null;
		String selectQuery = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setString(1, email);

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) { // Move the cursor to the first row
					user = new User();
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;
	}
	
	/**
	 * Updates information about a User in the database.
	 *
	 * @param user The User object with updated information.
	 * @return True if the update was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean updateUser(User user) throws DAOException {
	    String updateQuery = "UPDATE users SET  phone_no = ? ,first_name = ?, last_name = ?  WHERE email = ?";
	    try (
	        // Get connection
	        Connection connection = ConnectionUtil.getConnection();
	        // Prepare SQL statement
	        PreparedStatement statement = connection.prepareStatement(updateQuery);
	    ) {
	     
	    	statement.setLong(1, user.getPhoneNo());
	        statement.setString(2, user.getFirstName());
	        statement.setString(3, user.getLastName());
	        statement.setString(4, user.getEmail());
	        // Execute the query
	        int rows = statement.executeUpdate();
	        // Return successful or not
	        return (rows > 0);
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	/**
	 * Retrieves a user by their email.
	 *
	 * @param searchValue The email of the user to retrieve
	 * @return The User object if found, otherwise null
	 * @throws DAOException If an error occurs during database operation
	 */
	public User getUser(String searchEmail) throws DAOException {
		User userDetails = new User();
		String query = "SELECT first_name, last_name, phone_no,email,user_id  FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, searchEmail);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
			    	User user = new User();
				
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUserId(rs.getInt("user_id"));
					user.setPhoneNo(rs.getLong("phone_no"));
					userDetails = user;
					System.out.println(user.toString());
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return userDetails;
	}

	/**
	 * Creates a new user in the database.
	 *
	 * @param user The User object representing the user to be created.
	 * @return True if the user creation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean createUser(User user) throws DAOException {
		String insertQuery = "INSERT INTO users (email, password, first_name, last_name, phone_no) VALUES (?, ?, ?, ?, ?)";

		try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();

				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setLong(5, user.getPhoneNo());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
	/**
	 * Checks if a user with the given email exists.
	 *
	 * @param email The email of the user to check for existence.
	 * @return True if the user with the given email exists and is active, otherwise
	 * false.
	 * @throws DAOException If an error occurs during the database operation.
	 */
	public boolean doesUserExist(String email) throws DAOException {
		String query = "SELECT 1 FROM users WHERE email = ? AND isActive = TRUE";
		try (Connection connection = ConnectionUtil.getConnection();
		     PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				return rs.next(); // If a row is found, the user exists
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Marks a User as inactive in the database.
	 *
	 * @param userId The unique identifier of the User to be marked as inactive.
	 * @return True if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean deleteUser(int userId) throws DAOException {
	    String query = "UPDATE users SET isActive = false WHERE user_id = ?;";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(query);) {
	        pst.setInt(1, userId);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


}
