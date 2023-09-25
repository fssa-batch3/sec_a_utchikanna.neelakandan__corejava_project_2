package com.fssa.cinephile.model;

public class Comments {

	private int commentId;
	private Movie movie;
	private String comment ;
	private User user;
	
//  give rating constructor
	public Comments(String comment, Movie movie, User user) {
		this.movie = movie;
		this.user = user;
		this.comment = comment;
	}

	// read rating constructor
	public Comments(int commentId) {
		this.commentId = commentId;
	}



	public Comments() {

	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", movie=" + movie + ", comment=" + comment + ", user=" + user
				+ "]";
	}



}
