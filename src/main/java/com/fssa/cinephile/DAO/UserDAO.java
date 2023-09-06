package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.cinephile.DAO.exceptions.DAOException;
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
	public User checkUserLogin(String email, String password) throws DAOException {
		User user = null;
		String selectQuery = "SELECT * FROM user WHERE email = ?";
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
	 * Retrieves a user by their email.
	 *
	 * @param searchValue The email of the user to retrieve
	 * @return The User object if found, otherwise null
	 * @throws DAOException If an error occurs during database operation
	 */
	public User getUser(String searchEmail) throws DAOException {
		User user1 = null;
		String query = "SELECT user_id,password,phone_no,email,first_name,last_name FROM user WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, searchEmail);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setPassword(rs.getString("password"));
					user.setPhoneNo(rs.getLong("phone_no"));
					user.setEmail(rs.getString("email"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));

					user1 = user;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user1;
	}

	/**
	 * Creates a new user in the database.
	 *
	 * @param user The User object representing the user to be created.
	 * @return True if the user creation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean createUser(User user) throws DAOException {
		String insertQuery = "INSERT INTO user (email, password, first_name, last_name, phone_no) VALUES (?, ?, ?, ?, ?)";

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

}
