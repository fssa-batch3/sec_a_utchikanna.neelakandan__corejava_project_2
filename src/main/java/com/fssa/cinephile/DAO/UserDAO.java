package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.util.ConnectionUtil;

public class UserDAO {

	// Connect to database
	
	
	
	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		try {
//			get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String insertQuery = "Select * From user Where email = ?";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1,email);
			
			ResultSet rs = statement.executeQuery();
		
			boolean userExits = rs.next();
			if(userExits) {
				System.out.println("User is there.");
				String storedPassword = rs.getString("password");
				System.out.println(storedPassword);
				
				if(storedPassword.equals(password)) {
					System.out.println("Log in successfully");
				}else {
					System.out.println("Bad credentials");
				}
			}else {
				System.out.println("User credentials is not there");
			}
		}catch(SQLException e) {
			throw new DAOException(e) ;
		}
		
		return false;
	}

	public boolean createUser(User user) throws DAOException {

		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email, password, first_name , last_name , phone_no) VALUES(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setInt(5, user.getPhoneNo());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}