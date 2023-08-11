package com.fssa.cinephile.model;

public class Movie {

  private String title;
  private int movieId;
  private int movieRating;
  private String imageUrl;
  
  public Movie(String title, int movieId, int movieRating, String imageUrl) {
		super();
		this.title = title;
		this.movieId = movieId;
		this.movieRating = movieRating;
		this.imageUrl = imageUrl;
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
