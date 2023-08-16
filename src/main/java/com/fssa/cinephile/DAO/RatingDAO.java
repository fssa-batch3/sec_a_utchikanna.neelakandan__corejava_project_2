package com.fssa.cinephile.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Rating;

import io.github.cdimascio.dotenv.Dotenv;

public class RatingDAO {

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
		   
		public boolean addRating(Rating rating) throws DAOException {
			String insertQuery = "Insert INTO rating (rating_id,movie_id, user_id,rating) VALUES(?,?,?,?)";
			try (
				// Get connection
				Connection connection = getConnection();

				// Prepare SQL statement
				
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				){
				statement.setInt(1, rating.getRatingId());
				statement.setInt(3, rating.getRating());
				statement.setInt(2, rating.getMovieId());
				statement.setInt(4, rating.getUserId());
				

				// Execute the query
				int rows = statement.executeUpdate();
				// Return successful or not
				return (rows > 0);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		 public static List<Rating> getAllRatings() throws DAOException {
		        List<Rating> ratingList = new ArrayList<>();
		        String query = "SELECT * FROM rating WHERE isActive = true;;";
		        try  (
		        	Connection connection = getConnection();
		        	
					PreparedStatement statement = connection.prepareStatement(query);
		        		){
					 ResultSet rs = statement.executeQuery();
		            while (rs.next()) {
		            	Rating rating = new Rating();
		            	rating.setRatingId(rs.getInt("rating_id"));
		            	rating.setRating(rs.getInt("rating"));
		            	rating.setMovieId(rs.getInt("movie_id"));
		            	rating.setUserId(rs.getInt("user_id"));
		               
		            	ratingList.add(rating);
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		        return ratingList;
		    }
		
		 public boolean updateRating(Rating rating) throws DAOException{
			    String updateQuery = "UPDATE rating SET  rating = ? WHERE rating_id = ?";
			    try (
			        // Get connection
			        Connection connection = getConnection();
			        // Prepare SQL statement
			        PreparedStatement statement = connection.prepareStatement(updateQuery);
			    ){
			        
			        statement.setInt(1, rating.getRating());
			        

			        // Execute the query
			        int rows = statement.executeUpdate();
			        // Return successful or not
			        return (rows > 0);
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    }
		    }
			

}
