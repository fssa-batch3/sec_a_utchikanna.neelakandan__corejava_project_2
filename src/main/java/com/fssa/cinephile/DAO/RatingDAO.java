/**
 * 
 */
package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.util.ConnectionUtil;



/**
 * 
 */
public class RatingDAO {

    private static final String INSERT_OR_UPDATE_RATING_QUERY =
            "INSERT INTO ratings (user_id, movie_id, rating) VALUES (?, ?, ?) " +
            "ON DUPLICATE KEY UPDATE rating = VALUES(rating)";

    public boolean addRating(Rating rating) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(INSERT_OR_UPDATE_RATING_QUERY)) {

            pst.setInt(1, rating.getUserId());
            pst.setInt(2, rating.getMovieId());
            pst.setInt(3, rating.getRating());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    private static final String GET_RATING_BY_MOVIE_QUERY =
            "SELECT AVG(rating) AS average_rating, COUNT(*) AS rating_count " +
            "FROM ratings WHERE movie_id = ?";

    public Map<String, Object> getRatingByMovie(int movieId) throws DAOException {
        Map<String, Object> ratingInfo = new HashMap<>();

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(GET_RATING_BY_MOVIE_QUERY)) {

            pst.setInt(1, movieId);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                ratingInfo.put("average_rating", resultSet.getDouble("average_rating"));
                ratingInfo.put("rating_count", resultSet.getInt("rating_count"));
            }

        } catch (SQLException  e) {
            throw new DAOException(e);
        }

        return ratingInfo;
    }

    private static final String GET_RATING_BY_MOVIE_AND_USER_QUERY =
            "SELECT rating FROM ratings WHERE movie_id = ? AND user_id = ?";

    public int getRatingByMovieAndUser(int movieId, int userId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(GET_RATING_BY_MOVIE_AND_USER_QUERY)) {

            pst.setInt(1, movieId);
            pst.setInt(2, userId);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("rating");
            }

        } catch (SQLException  e) {
            throw new DAOException(e);
        }

        return 0; 
    }

}