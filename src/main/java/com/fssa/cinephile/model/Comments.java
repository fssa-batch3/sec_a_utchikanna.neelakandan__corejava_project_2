package com.fssa.cinephile.model;

/**
 * A class representing user comments on movies.
 * 
 * @author UtchikannaNeelakanda
 */
public class Comments {

    private int commentId;  
    private Movie movie;    
    private String comment; 
    private User user;      

    /**
     * Constructs a Comments object with a user's comment, associated movie, and user information.
     *
     * @param comment The user's comment text.
     * @param movie   The associated Movie object.
     * @param user    The user who made the comment.
     */
    public Comments(String comment, Movie movie, User user) {
        this.movie = movie;
        this.user = user;
        this.comment = comment;
    }

    /**
     * Constructs a Comments object with a comment's unique identifier.
     *
     * @param commentId The unique identifier for the comment.
     */
    public Comments(int commentId) {
        this.commentId = commentId;
    }

    /**
     * Default constructor for Comments.
     */
    public Comments() {
    }

    /**
     * Retrieves the unique identifier for the comment.
     *
     * @return The unique identifier for the comment.
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * Sets the unique identifier for the comment.
     *
     * @param commentId The unique identifier for the comment.
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    /**
     * Retrieves the associated Movie object.
     *
     * @return The associated Movie object.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the associated Movie object.
     *
     * @param movie The associated Movie object.
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Retrieves the user's comment text.
     *
     * @return The user's comment text.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the user's comment text.
     *
     * @param comment The user's comment text.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Retrieves the User object representing the user who made the comment.
     *
     * @return The User object representing the user who made the comment.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the User object representing the user who made the comment.
     *
     * @param user The User object representing the user who made the comment.
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comments [commentId=" + commentId + ", movie=" + movie + ", comment=" + comment + ", user=" + user + "]";
    }
}
