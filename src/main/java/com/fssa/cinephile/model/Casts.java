package com.fssa.cinephile.model;

/**
 * A class representing the cast members of a movie.
 * 
 * @author UtchikannaNeelakanda
 */
public class Casts {

    private String actorName;  
    private String actorLink;  
    private String actorImage; 
    private int castsId;      
    private int movieId;      

    /**
     * Retrieves the name of the actor.
     * 
     * @return The name of the actor.
     */
    public String getActorName() {
        return actorName;
    }

    /**
     * Sets the name of the actor.
     * 
     * @param actorName The name of the actor.
     */
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    /**
     * Retrieves a link or identifier related to the actor.
     * 
     * @return A link or identifier related to the actor.
     */
    public String getActorLink() {
        return actorLink;
    }

    /**
     * Sets a link or identifier related to the actor.
     * 
     * @param actorLink A link or identifier related to the actor.
     */
    public void setActorLink(String actorLink) {
        this.actorLink = actorLink;
    }

    /**
     * Retrieves the image of the actor.
     * 
     * @return The image of the actor.
     */
    public String getActorImage() {
        return actorImage;
    }

    /**
     * Sets the image of the actor.
     * 
     * @param actorImage The image of the actor.
     */
    public void setActorImage(String actorImage) {
        this.actorImage = actorImage;
    }

    /**
     * Retrieves the unique identifier for the cast entry.
     * 
     * @return The unique identifier for the cast entry.
     */
    public int getCastsId() {
        return castsId;
    }

    /**
     * Sets the unique identifier for the cast entry.
     * 
     * @param castsId The unique identifier for the cast entry.
     */
    public void setCastsId(int castsId) {
        this.castsId = castsId;
    }

    /**
     * Retrieves the unique identifier of the associated movie.
     * 
     * @return The unique identifier of the associated movie.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Sets the unique identifier of the associated movie.
     * 
     * @param movieId The unique identifier of the associated movie.
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
