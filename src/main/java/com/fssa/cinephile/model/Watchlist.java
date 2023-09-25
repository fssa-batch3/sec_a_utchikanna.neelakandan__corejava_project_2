package com.fssa.cinephile.model;

public class Watchlist {
	
	private int watchlist_id;
	private int movie_id;
	private int user_id;
	
	
	public Watchlist(int movie_id, int user_id) {
      this.movie_id = movie_id;
      this.user_id = user_id;
	}
	public Watchlist() {
		
	}
	public int getWatchlistId() {
		return watchlist_id;
	}
	public void setWatchlistId(int watchlist_id) {
		this.watchlist_id = watchlist_id;
	}
	public int getMovieId() {
		return movie_id;
	}
	public void setMovieId(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	

}
