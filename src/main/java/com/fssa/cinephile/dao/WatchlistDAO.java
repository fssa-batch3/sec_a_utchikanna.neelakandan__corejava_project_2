package com.fssa.cinephile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.dao.exception.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Watchlist;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * A data access object (DAO) for managing user watchlists.
 * 
 * @author UtchikannaNeelakanda
 * 
 */

public class WatchlistDAO {

    /**
     * Adds a movie to the user's watchlist.
     * 
     * @param watchlist The Watchlist object containing user and movie information.
     * @return `true` if the movie was successfully added to the watchlist, `false` otherwise.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean addWatchlist(Watchlist watchlist) throws DAOException {
        String query = "INSERT INTO watchlists (user_id , movie_id) VALUES (?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);) {
            pst.setInt(1, watchlist.getUserId());
            pst.setInt(2, watchlist.getMovieId());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieves a list of movies in a user's watchlist.
     * 
     * @param userId The ID of the user for which the watchlist is to be retrieved.
     * @return A list of Movie objects in the user's watchlist.
     * @throws DAOException If there is an issue with the database operation.
     */
    public List<Movie> getMoviesInUserWatchlist(int userId) throws DAOException {
        List<Movie> movieList = new ArrayList<>();
        String query = "SELECT m.movie_trailer, m.movie_title, m.movie_image_url, m.movie_id, w.watchlist_id "
                + "FROM watchlists w " + "INNER JOIN movies m ON w.movie_id = m.movie_id " + "WHERE w.user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieTitle(rs.getString("movie_title"));
                movie.setMovieTrailer(rs.getString("movie_trailer"));
                movie.setMovieImgUrl(rs.getString("movie_image_url"));
                movie.setMovieId(rs.getInt("movie_id"));
                movie.setWatchlistId(rs.getInt("watchlist_id"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return movieList;
    }

    /**
     * Removes a movie from the user's watchlist by its ID.
     * 
     * @param watchlistId The ID of the watchlist entry to be removed.
     * @return `true` if the movie was successfully removed from the watchlist, `false` otherwise.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean removeWatchlist(int watchlistId) throws DAOException {
        String query = "DELETE FROM watchlists WHERE watchlist_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);) {
            pst.setInt(1, watchlistId);
            int rowsAffected = pst.executeUpdate();
            return (rowsAffected > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
