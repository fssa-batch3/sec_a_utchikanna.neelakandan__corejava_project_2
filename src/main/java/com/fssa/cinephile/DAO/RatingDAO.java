package com.fssa.cinephile.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
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
		   
		public boolean rating(Rating rating) throws DAOException {
			  
			try {
				// Get connection
				Connection connection = getConnection();

				// Prepare SQL statement
				String insertQuery = "Insert INTO rating (rating_id, rating, movie_id, user_id) VALUES(?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insertQuery);
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
		       
		        try  {
		        	Connection connection = getConnection();
		        	 String query = "SELECT * FROM rating WHERE isActive = true;;";
					PreparedStatement statement = connection.prepareStatement(query);
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
		
		 public static  Rating updateRating(Rating rating) throws DAOException {
		        StringBuilder queryBuilder = new StringBuilder("UPDATE rating SET ");
		        List<String> setColumns = new ArrayList<>();
		        List<Object> setValues = new ArrayList<>();

		        if (rating.getRatingId() != 0) {
		            setColumns.add("rating_id = ?");
		            setValues.add(rating.getRatingId());
		        }
		        if (rating.getRating() != 0) {
		            setColumns.add("rating = ?");
		            setValues.add(rating.getRating());
		        }
		        if (rating.getMovieId() != 0) {
		            setColumns.add("movie_id = ?");
		            setValues.add(rating.getMovieId());
		        }
		        if (rating.getUserId() != 0) {
		            setColumns.add("user_id = ?");
		            setValues.add(rating.getUserId());
		        }


		        if (setColumns.isEmpty()) {
		            return rating;
		        }
		        queryBuilder.append(String.join(", ", setColumns));
		        queryBuilder.append(" WHERE rating_id = ?;");
		        try (Connection connection = getConnection();
		             PreparedStatement pst = connection.prepareStatement(queryBuilder.toString())) {

		            int index = 1;
		            for (Object value : setValues) {
		                pst.setObject(index++, value);
		            }
		            pst.setInt(index, rating.getRatingId());

		            int rowsAffected = pst.executeUpdate();
		            if (rowsAffected > 0) {
		                return rating;
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
				return rating;
		    }
			

}
