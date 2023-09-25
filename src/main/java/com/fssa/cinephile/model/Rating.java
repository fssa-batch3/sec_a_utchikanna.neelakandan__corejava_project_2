package com.fssa.cinephile.model;

public class Rating {

	private int ratingId;
	private int movieId;
	private int movieRating;
	private int userId;

//  give rating constructor
	public Rating(int movieRating, int movieId, int userId) {
		this.movieId = movieId;
		this.userId = userId;
		this.movieRating = movieRating;
	}

	// read rating constructor
	public Rating(int ratingId) {
		this.ratingId = ratingId;
	}



	public Rating() {

	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return movieRating;
	}

	public void setRating(int movieRating) {
		this.movieRating = movieRating;
	}

}
