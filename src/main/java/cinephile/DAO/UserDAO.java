package cinephile.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinephile.DAO.exceptions.DAOException;
import cinephile.model.User;
import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {

	// Connect to database
	
	
	public static Connection getConnection() throws SQLException {
		
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;
		Connection connection = null;
		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		try {
	  connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect");
		}
		return connection;

	}

	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		try {
//			get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Select * From user Where email = ?";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1,email);
			
			ResultSet rs = statement.executeQuery();
			
			boolean userExits = rs.next();
			if(userExits) {
				System.out.println("User is there.");
				String storedPassword = rs.getString("Password");
				
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
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email, password, firstName , lastName , phoneNo) VALUES(?,?,?,?,?)";
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