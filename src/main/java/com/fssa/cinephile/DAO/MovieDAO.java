package com.fssa.cinephile.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.util.ConnectionUtil;

public class MovieDAO {

		  
		public boolean addMovie(Movie movie) throws DAOException {
			String insertQuery = "Insert INTO movie (movie_title, movie_rating , movie_image_url) VALUES(?,?,?)";
			try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();
				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(insertQuery);){
				
				statement.setString(1, movie.getMovieTitle());
				statement.setInt(2, movie.getMovieRating());
				statement.setString(3, movie.getMovieImgUrl());
				

				// Execute the query
				int rows = statement.executeUpdate();
				// Return successful or not
				return (rows == 1);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		   public boolean readMovie(Movie movie) throws DAOException {
		        String insertQuery = "SELECT * from movie WHERE movie_title = ? ";
		        try (Connection connection = ConnectionUtil.getConnection();
		             PreparedStatement statement = connection.prepareStatement(insertQuery)
		        ) {
		            statement.setString(1, movie.getMovieTitle());

		            try (ResultSet resultSet = statement.executeQuery()) {
		                return resultSet.next();
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }

		    }
		
		 public boolean updateMovie(Movie movie) throws DAOException {
			    String updateQuery = "UPDATE movie SET movie_title = ?, movie_rating = ?, movie_image_url = ? WHERE movie_id = ?";
			    try (
			        // Get connection
			        Connection connection = ConnectionUtil.getConnection();
			        // Prepare SQL statement
			        PreparedStatement statement = connection.prepareStatement(updateQuery);
			    ){
			        statement.setString(1, movie.getMovieTitle());
			        statement.setInt(2, movie.getMovieRating());
			        statement.setString(3, movie.getMovieImgUrl());
			        statement.setInt(4, movie.getMovieId());

			        // Execute the query
			        int rows = statement.executeUpdate();
			        System.out.println(rows);
			        // Return successful or not
			        return (rows > 0);
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    }
			}


		    public static boolean deleteMovie(Movie movie) throws DAOException {
		        String query = "UPDATE movie SET isActive = false WHERE movie_title = ?;";
		        try (Connection connection = ConnectionUtil.getConnection();
		             PreparedStatement pst = connection.prepareStatement(query)) {

		            pst.setString(1, movie.getMovieTitle());

		            int rowsAffected = pst.executeUpdate();
		            return rowsAffected > 0;
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		    }

		

}
