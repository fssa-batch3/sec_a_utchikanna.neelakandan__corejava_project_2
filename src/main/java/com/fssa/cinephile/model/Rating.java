package com.fssa.cinephile.model;

public class Rating {

	private int ratingId;
	private Movie movie;
	private int movieRating;
	private User user;

//  give rating constructor
	public Rating(int movieRating, Movie movie, User user) {
		this.movie = movie;
		this.user = user;
		this.movieRating = movieRating;
	}

	// read rating constructor
	public Rating(int ratingId) {
		this.ratingId = ratingId;
	}

//  update rating constructor
	public Rating(int ratingId, int movieRating, Movie movie, User user) {
		this.movie = movie;
		this.ratingId = ratingId;
		this.user = user;
		this.movieRating = movieRating;
	}

	public Rating() {

	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return movieRating;
	}

	public void setRating(int movieRating) {
		this.movieRating = movieRating;
	}

}
