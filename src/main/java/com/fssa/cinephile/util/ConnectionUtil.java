package com.fssa.cinephile.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 * 
 * @author UtchikannaNeelakanda
 */
public class ConnectionUtil {

	// Private constructor to prevent instantiation
	private ConnectionUtil() {
		// Do nothing (empty constructor)
	}

	/**
	 * Establishes a connection to the database.
	 *
	 * @return A database connection.
	 * @throws SQLException If a database access error occurs.
	 */
	public static Connection getConnection() {
		// Database URL and credentials
		final String dbUrl;
		final String dbUser;
		final String dbPassword;



//		Local Host
		dbUrl = System.getenv("dbUrl");
		dbUser = System.getenv("dbUser");
		dbPassword = System.getenv("dbPassword");
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {

			throw new RuntimeException("Unable to connect database", e);
		} catch (ClassNotFoundException e) {

			throw new RuntimeException("data base Driver class not found", e);
		}

	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	
}
