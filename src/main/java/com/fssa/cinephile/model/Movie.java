package com.fssa.cinephile.model;

/**
 * The {@code Movie} class represents a movie entity in the application. It
 * includes information about the movie's title, ID, rating, and image URL.
 * 
 * @author UtchikannaNeelakanda
 */

public class Movie {

	

	@Override
	public String toString() {
		return "Movie [title=" + title + ", movieId=" + movieId + ", imageUrl=" + imageUrl + ", movieTrailer="
				+ movieTrailer + ", movieType=" + movieType + ", watchlist_id=" + watchlistId + "]";
	}

	private String title;
	private int movieId;
	private String imageUrl;
	private String movieTrailer;
	private String movieType;
	private int watchlistId;

	public int getWatchlistId() {
		return watchlistId;
	}

	public void setWatchlistId(int watchlist_id) {
		this.watchlistId = watchlist_id;
	}

	/**
	 * Constructs a new {@code Movie} object with the provided information.
	 *
	 * @param title        The title of the movie.
	 * @param movieRating  The rating of the movie.
	 * @param imageUrl     The URL of the movie's image.
	 * @param movieTrailer The Trailer of the movie.
	 * @param movieType    The Type of the movie.
	 */
	public Movie(String title, String imageUrl, String movieTrailer, String movieType) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.movieTrailer = movieTrailer;
		this.movieType = movieType;
	}

	/**
	 * Gets the URL of the movie's trailer.
	 *
	 * @return The URL of the movie's trailer.
	 */
	public String getMovieTrailer() {
		return movieTrailer;
	}

	/**
	 * Sets the URL of the movie's trailer.
	 *
	 * @param movieTrailer The URL of the movie's trailer.
	 */
	public void setMovieTrailer(String movieTrailer) {
		this.movieTrailer = movieTrailer;
	}

	/**
	 * Gets the type or category of the movie.
	 *
	 * @return The type or category of the movie.
	 */
	public String getMovieType() {
		return movieType;
	}

	/**
	 * Sets the type or category of the movie.
	 *
	 * @param movieType The type or category of the movie.
	 */
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	/**
	 * Constructs a new {@code Movie} object with the provided information.
	 *
	 * @param title        The title of the movie.
	 * @param movieId      The ID of the movie.
	 * @param movieRating  The rating of the movie.
	 * @param imageUrl     The URL of the movie's image.
	 * @param movieTrailer The Trailer of the movie.
	 * @param movieType    The Type of the movie.
	 */
	public Movie(String title, int movieId, String imageUrl, String movieTrailer, String movieType) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.movieId = movieId;
		this.movieTrailer = movieTrailer;
		this.movieType = movieType;
	}

	/**
	 * Constructs a new empty {@code Movie} object.
	 */
	public Movie() {
		// Empty constructor
	}

	public Movie(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * Retrieves the title of the movie.
	 *
	 * @return The title of the movie.
	 */
	public String getMovieTitle() {
		return title;
	}

	/**
	 * Sets the title of the movie.
	 *
	 * @param title The title of the movie.
	 */
	public void setMovieTitle(String title) {
		this.title = title;
	}

	/**
	 * Retrieves the ID of the movie.
	 *
	 * @return The ID of the movie.
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets the ID of the movie.
	 *
	 * @param movieId The ID of the movie.
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * Retrieves the URL of the movie's image.
	 *
	 * @return The URL of the movie's image.
	 */
	public String getMovieImgUrl() {
		return imageUrl;
	}

	/**
	 * Sets the URL of the movie's image.
	 *
	 * @param imageUrl The URL of the movie's image.
	 */
	public void setMovieImgUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
