package com.fssa.cinephile.model;

/**
 * A class representing user ratings for movies.
 * 
 * @author UtchikannaNeelakanda
 * 
 */
public class Rating {

    private int ratingId;    
    private int movieId;   
    private int movieRating; 
    private int userId;     

    /**
     * Constructs a Rating object with a user's movie rating, associated movie, and user information.
     *
     * @param movieRating The user's movie rating.
     * @param movieId     The unique identifier of the associated movie.
     * @param userId      The user who submitted the rating.
     */
    public Rating(int movieRating, int movieId, int userId) {
        this.movieId = movieId;
        this.userId = userId;
        this.movieRating = movieRating;
    }

    /**
     * Constructs a Rating object with a rating's unique identifier.
     *
     * @param ratingId The unique identifier for the rating.
     */
    public Rating(int ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Default constructor for Rating.
     */
    public Rating() {
    }

    /**
     * Retrieves the unique identifier for the rating.
     *
     * @return The unique identifier for the rating.
     */
    public int getRatingId() {
        return ratingId;
    }

    /**
     * Sets the unique identifier for the rating.
     *
     * @param ratingId The unique identifier for the rating.
     */
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Retrieves the unique identifier of the associated movie.
     *
     * @return The unique identifier of the associated movie.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Sets the unique identifier of the associated movie.
     *
     * @param movieId The unique identifier of the associated movie.
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Retrieves the user's movie rating.
     *
     * @return The user's movie rating.
     */
    public int getRating() {
        return movieRating;
    }

    /**
     * Sets the user's movie rating.
     *
     * @param movieRating The user's movie rating.
     */
    public void setRating(int movieRating) {
        this.movieRating = movieRating;
    }

    /**
     * Retrieves the user who submitted the rating.
     *
     * @return The user who submitted the rating.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user who submitted the rating.
     *
     * @param userId The user who submitted the rating.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
