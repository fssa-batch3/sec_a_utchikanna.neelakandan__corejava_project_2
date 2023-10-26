package com.fssa.cinephile.model;

/**
 * A class representing user movie watchlist entries.
 * 
 * @author UtchikannaNeelakanda
 *  
 */
public class Watchlist {
    
    private int watchlistId; 
    private int movieId;     
    private int userId;     

    /**
     * Constructs a Watchlist entry with the provided movie and user identifiers.
     *
     * @param movie_id The unique identifier of the associated movie.
     * @param user_id  The user who added the movie to their watchlist.
     */
    public Watchlist(int movieId, int userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    /**
     * Default constructor for Watchlist.
     */
    public Watchlist() {
    }

    /**
     * Retrieves the unique identifier for the watchlist entry.
     *
     * @return The unique identifier for the watchlist entry.
     */
    public int getWatchlistId() {
        return watchlistId;
    }

    /**
     * Sets the unique identifier for the watchlist entry.
     *
     * @param watchlist_id The unique identifier for the watchlist entry.
     */
    public void setWatchlistId(int watchlistId) {
        this.watchlistId = watchlistId;
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
     * @param movie_id The unique identifier of the associated movie.
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Retrieves the user who added the movie to their watchlist.
     *
     * @return The user who added the movie to their watchlist.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user who added the movie to their watchlist.
     *
     * @param user_id The user who added the movie to their watchlist.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
