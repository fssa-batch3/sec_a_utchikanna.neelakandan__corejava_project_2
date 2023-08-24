package com.fssa.cinephile.model;

public class Movie {

  private String title;
  private int movieId;
  private int movieRating;
  private String imageUrl;
//  add movie constructor
  public Movie(String title, int movieRating, String imageUrl) {
		
		this.title = title;
		this.movieRating = movieRating;
		this.imageUrl = imageUrl;
	}
//  update movie constructor
  public Movie(String title ,int movieId, int movieRating, String imageUrl) {
		this.title = title;
		this.movieRating = movieRating;
		this.imageUrl = imageUrl;
		this.movieId = movieId;
	}
public Movie() {
	// TODO Auto-generated constructor stub
}


public String getMovieTitle() {
	return title;
}
public void setMovieTitle(String title) {
	this.title = title;
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public int getMovieRating() {
	return movieRating;
}
public void setMovieRating(int movieRating) {
	this.movieRating = movieRating;
}
public String getMovieImgUrl() {
	return imageUrl;
}
public void setMovieImgUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}



  
  

}
