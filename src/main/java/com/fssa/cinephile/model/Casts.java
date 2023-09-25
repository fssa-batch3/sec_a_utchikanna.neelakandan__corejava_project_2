package com.fssa.cinephile.model;

public class Casts {

	private String actorName;
	private String actorLink;
	private String actorImage;
	private int casts_id;
	private int movie_id;
	
	
	@Override
	public String toString() {
		return "Casts [actorName=" + actorName + ", actorLink=" + actorLink + ", actorImage=" + actorImage
				+ ", casts_id=" + casts_id + ", movie_id=" + movie_id + "]";
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorLink() {
		return actorLink;
	}
	public void setActorLink(String actorLink) {
		this.actorLink = actorLink;
	}
	public String getActorImage() {
		return actorImage;
	}
	public void setActorImage(String actorImage) {
		this.actorImage = actorImage;
	}
	public int getCastsId() {
		return casts_id;
	}
	public void setCastsId(int casts_id) {
		this.casts_id = casts_id;
	}
	public int getMovieId() {
		return movie_id;
	}
	public void setMovieId(int movie_id) {
		this.movie_id = movie_id;
	}
	
}
