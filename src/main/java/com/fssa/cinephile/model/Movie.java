package com.fssa.cinephile.model;

/**
 * The {@code Movie} class represents a movie entity in the application. It
 * includes information about the movie's title, ID, rating, and image URL.
 * 
 * @author UtchikannaNeelakanda
 */
public class Movie {

	private String title;
	private int movieId;
	private int movieRating;
	private String imageUrl;

	/**
	 * Constructs a new {@code Movie} object with the provided information.
	 *
	 * @param title       The title of the movie.
	 * @param movieRating The rating of the movie.
	 * @param imageUrl    The URL of the movie's image.
	 */
	public Movie(int movieRating, String title, String imageUrl) {
		this.title = title;
		this.movieRating = movieRating;
		this.imageUrl = imageUrl;
	}


	/**
	 * Constructs a new {@code Movie} object with the provided information.
	 *
	 * @param title       The title of the movie.
	 * @param movieId     The ID of the movie.
	 * @param movieRating The rating of the movie.
	 * @param imageUrl    The URL of the movie's image.
	 */
	public Movie(String title, int movieId, int movieRating, String imageUrl) {
		this.title = title;
		this.movieRating = movieRating;
		this.imageUrl = imageUrl;
		this.movieId = movieId;
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
	 * Retrieves the rating of the movie.
	 *
	 * @return The rating of the movie.
	 */
	public int getMovieRating() {
		return movieRating;
	}

	/**
	 * Sets the rating of the movie.
	 *
	 * @param movieRating The rating of the movie.
	 */
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
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
