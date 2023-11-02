package com.fssa.cinephile.model;

/**
 * The {@code MovieDetails} class represents details about a movie entity in the application.
 * It includes information such as the movie's story, release date, award details, and movie links.
 * 
 * @author UtchikannaNeelakanda
 */

public class MovieDetails {

    private int movieDetailsId; 
    private Movie movie;      
    private String story;       
    private String releaseDate; 
    private String awardName;  
    private String awardWiki;  
    private String directorName; 
    private String directorWiki; 
    private String movieLink;  

    /**
     * Constructs a new {@code MovieDetails} object with the provided information.
     *
     * @param story       The story of the movie.
     * @param releaseDate The release date of the movie.
     * @param awardName   The award name of the movie.
     * @param awardWiki   The URL for award details.
     * @param movieLink   The URL for watching the movie.
     * @param movie       The associated Movie object.
     * @param directorName The name of the movie director.
     * @param directorWiki The URL for director details.
     */
    public MovieDetails(String story, String releaseDate, String awardName, String awardWiki, String movieLink, Movie movie, String directorName, String directorWiki) {
        this.story = story;
        this.movie = movie;
        this.releaseDate = releaseDate;
        this.awardName = awardName;
        this.awardWiki = awardWiki;
        this.movieLink = movieLink;
        this.directorName = directorName;
        this.directorWiki = directorWiki;
    }

    /**
     * Constructs a new empty {@code MovieDetails} object.
     */
    public MovieDetails() {
        // Empty constructor
    }

    /**
     * Retrieves the unique identifier for movie details.
     *
     * @return The unique identifier for movie details.
     */
    public int getMovieDetailsId() {
        return movieDetailsId;
    }

    /**
     * Sets the unique identifier for movie details.
     *
     * @param movieDetailsId The unique identifier for movie details.
     */
    public void setMovieDetailsId(int movieDetailsId) {
        this.movieDetailsId = movieDetailsId;
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
     * Retrieves the story of the movie.
     *
     * @return The story of the movie.
     */
    public String getStory() {
        return story;
    }

    /**
     * Sets the story of the movie.
     *
     * @param story The story of the movie.
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * Retrieves the release date of the movie.
     *
     * @return The release date of the movie.
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the movie.
     *
     * @param releaseDate The release date of the movie.
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Retrieves the award name of the movie.
     *
     * @return The award name of the movie.
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * Sets the award name of the movie.
     *
     * @param awardName The award name of the movie.
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * Retrieves the URL for award details.
     *
     * @return The URL for award details.
     */
    public String getAwardWiki() {
        return awardWiki;
    }

    /**
     * Sets the URL for award details.
     *
     * @param awardWiki The URL for award details.
     */
    public void setAwardWiki(String awardWiki) {
        this.awardWiki = awardWiki;
    }

    /**
     * Retrieves the name of the movie director.
     *
     * @return The name of the movie director.
     */
    public String getDirectorName() {
        return directorName;
    }

    /**
     * Sets the name of the movie director.
     *
     * @param directorName The name of the movie director.
     */
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    /**
     * Retrieves the URL for director details.
     *
     * @return The URL for director details.
     */
    public String getDirectorWiki() {
        return directorWiki;
    }

    /**
     * Sets the URL for director details.
     *
     * @param directorWiki The URL for director details.
     */
    public void setDirectorWiki(String directorWiki) {
        this.directorWiki = directorWiki;
    }

    /**
     * Retrieves the URL for watching the movie.
     *
     * @return The URL for watching the movie.
     */
    public String getMovieLink() {
        return movieLink;
    }

    /**
     * Sets the URL for watching the movie.
     *
     * @param movieLink The URL for watching the movie.
     */
    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    @Override
    public String toString() {
        return "MovieDetails [movieDetailsId=" + movieDetailsId + ", movie=" + movie + ", story=" + story
                + ", releaseDate=" + releaseDate + ", awardName=" + awardName + ", awardWiki=" + awardWiki
                + ", directorName=" + directorName + ", directorWiki=" + directorWiki + ", movieLink=" + movieLink + "]";
    }
}
