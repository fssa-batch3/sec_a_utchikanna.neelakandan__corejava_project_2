package com.fssa.cinephile.model;

import java.util.Date;

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
     */
    public MovieDetails(String story, String releaseDate, String awardName, String awardWiki, String movieLink,Movie movie,String directorName, String directorWiki) {
        this.story = story;
        this.movie = movie;
        this.releaseDate = releaseDate;
        this.awardName = awardName;
        this.awardWiki = awardWiki;
        this.movieLink = movieLink;
        this.directorName = directorName;
        this.directorWiki = directorWiki;
    }

  

	@Override
	public String toString() {
		return "MovieDetails [movieDetailsId=" + movieDetailsId + ", movie=" + movie + ", story=" + story
				+ ", releaseDate=" + releaseDate + ", awardName=" + awardName + ", awardWiki=" + awardWiki
				+ ", DirectorName=" + directorName + ", DirectorWiki=" + directorWiki + ", movieLink=" + movieLink
				+ "]";
	}



	/**
     * Constructs a new empty {@code MovieDetails} object.
     */
    public MovieDetails() {
        // Empty constructor
    }

	public int getMovieDetailsId() {
		return movieDetailsId;
	}

	public void setMovieDetailsId(int movieDetailsId) {
		this.movieDetailsId = movieDetailsId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String string) {
		this.releaseDate = string;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardWiki() {
		return awardWiki;
	}

	public void setAwardWiki(String awardWiki) {
		this.awardWiki = awardWiki;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
    
    
    public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getDirectorWiki() {
		return directorWiki;
	}

	public void setDirectorWiki(String directorWiki) {
		this.directorWiki = directorWiki;
	}

   
}