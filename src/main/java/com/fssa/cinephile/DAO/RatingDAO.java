package com.fssa.cinephile.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.util.ConnectionUtil;
import com.google.protobuf.Timestamp;

public class RatingDAO {

		   
		public boolean addRating(Rating rating) throws DAOException {
			String insertQuery = "Insert INTO rating (rating,movie_id, user_id) VALUES(?,?,?,?)";
			try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();

				// Prepare SQL statement
				
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				){
				statement.setInt(1, rating.getRating());
				statement.setInt(2, rating.getMovieId());
				statement.setInt(3, rating.getUserId());
				

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
		        String query = "Select * from rating (inner join user user.user_id=rating.user_id)inner join movie movie.movie_id = rating.movie_id";
		        try  (
		        	Connection connection = ConnectionUtil.getConnection();
		        	
					Statement statement = connection.createStatement();
		        		){
		        	 
		               try (ResultSet resultSet = statement.executeQuery(query)) {
		                   while (resultSet.next()) {
		                       int rating1 = resultSet.getInt("rating");
		                       int movieId = resultSet.getInt("movie_id");
		                       int userId = resultSet.getInt("user_id");
		                     

		                       Rating getRating = new Rating(rating1,movieId,userId);
		                       ratingList.add(getRating);
		                   }
		               }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		        return ratingList;
		    }
		 
		 
		
		 public boolean updateRating(Rating rating) throws DAOException{
			    String updateQuery = "UPDATE rating SET  rating = ? WHERE user_id = ?";
			    try (
			        // Get connection
			        Connection connection = ConnectionUtil.getConnection();
			        // Prepare SQL statement
			        PreparedStatement statement = connection.prepareStatement(updateQuery);
			    ){
			        
			        statement.setInt(1, rating.getRating());
			        statement.setInt(2, rating.getUserId());
			        
			        // Execute the query
			        int rows = statement.executeUpdate();
			        // Return successful or not
			        return (rows > 0);
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    }
		    }
			

}
