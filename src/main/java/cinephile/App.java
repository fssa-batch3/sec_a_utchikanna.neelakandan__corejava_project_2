package cinephile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cinephile.model.User;

public class App {
	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinephile", "root", "123456");
		return connection;

	}

	// Get user from DB - Login
	public boolean login(String email, String password) {
		return false;
	}

	public boolean register(User user) throws SQLException {
		// Get connection
		Connection connection = getConnection();

		// Prepare SQL statement
		String insertQuery = "Insert INTO user (email,username, password) VALUES(?, ?,?)";
		PreparedStatement statement = connection.prepareStatement(insertQuery);
		statement.setString(1, user.getEmail());
		statement.setString(3, user.getPassword());

		// Execute the query
		int rows = statement.executeUpdate();

		// Return successful or not
		return (rows == 1);
	}

	// Get user from DB - Log in

}
