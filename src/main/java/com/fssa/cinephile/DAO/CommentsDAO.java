package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Comments;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with Comment entities in the database.
 * 
 * @author UtchikannaNeelakandan
 */

public class CommentsDAO {
    /**
     * Adds a new comment to a movie.
     * 
     * @param comment The comment to be added.
     * @return `true` if the comment was successfully added, `false` otherwise.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean addComment(Comments comment) throws DAOException {
        String query = "INSERT INTO comments (comment, movie_id, user_id) VALUES (?, ?, ?)";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, comment.getComment());
            statement.setInt(2, comment.getMovie().getMovieId());
            statement.setInt(3, comment.getUser().getUserId());

            int rows = statement.executeUpdate();
            return (rows > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieves a list of comments for a specific movie.
     * 
     * @param movieId The ID of the movie for which comments are to be retrieved.
     * @return A list of Comments objects associated with the specified movie.
     * @throws DAOException If there is an issue with the database operation.
     */
    public List<Comments> getMoviesComments(int movieId) throws DAOException {
        List<Comments> commentsList = new ArrayList<>();
        String query = "SELECT c.comment_id, c.comment, c.user_id, u.first_name, u.email, c.movie_id, m.movie_id " +
                       "FROM comments c " +
                       "INNER JOIN users u ON c.user_id = u.user_id " +
                       "INNER JOIN movies m ON c.movie_id = m.movie_id " + 
                       "WHERE c.movie_id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, movieId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Comments getComments = new Comments();
                getComments.setComment(rs.getString("comment"));
                getComments.setCommentId(rs.getInt("comment_id"));

                Movie movie = new Movie();
                movie.setMovieId(rs.getInt("movie_id"));

                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                user.setUserId(rs.getInt("user_id"));

                getComments.setMovie(movie);
                getComments.setUser(user);

                commentsList.add(getComments);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return commentsList;
    }

    /**
     * Updates the content of an existing comment.
     * 
     * @param comments The comment object containing the updated content and comment ID.
     * @return `true` if the comment was successfully updated, `false` otherwise.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean updateComment(Comments comments) throws DAOException {
        String updateQuery = "UPDATE comments SET comment = ? WHERE comment_id = ?";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateQuery);
        ) {
            statement.setString(1, comments.getComment());
            statement.setInt(2, comments.getCommentId());

            int rows = statement.executeUpdate();
            return (rows > 0);
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieves a comment for a specific movie and user.
     * 
     * @param movieId The ID of the movie.
     * @param userId   The ID of the user.
     * @return The comment as a string, or `null` if not found.
     * @throws DAOException If there is an issue with the database operation.
     */
    private static final String GET_COMMENT_BY_MOVIE_AND_USER_QUERY =
            "SELECT comment FROM comments WHERE movie_id = ? AND user_id = ?";
    public String getCommentByMovieAndUser(int movieId, int userId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(GET_COMMENT_BY_MOVIE_AND_USER_QUERY)) {

            pst.setInt(1, movieId);
            pst.setInt(2, userId);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("comment");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return null;
    }

    /**
     * Deletes a specific comment by its ID.
     * 
     * @param commentId The ID of the comment to be deleted.
     * @return `true` if the comment was successfully deleted, `false` otherwise.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean deleteComment(int commentId) throws DAOException {
        String query = "DELETE FROM comments WHERE comment_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);) {
            pst.setInt(1, commentId);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
