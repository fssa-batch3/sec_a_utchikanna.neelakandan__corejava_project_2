package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Watchlist;
import com.fssa.cinephile.util.ConnectionUtil;

public class WatchlistDAO {

	public boolean AddWatchlist(Watchlist watchlist) throws DAOException {

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

	public boolean removeWatchlist(int watchlistId) throws DAOException {
		System.out.println(watchlistId);
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
