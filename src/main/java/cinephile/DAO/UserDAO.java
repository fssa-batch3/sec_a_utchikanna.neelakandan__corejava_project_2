package cinephile.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cinephile.DAO.exceptions.DAOException;
import cinephile.model.User;

public class UserDAO {

	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinephile", "root", "123456");
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