package com.fssa.cinephile.model;

public class Casts {

	private String actor_name;
	private String actor_link;
	private String actor_image;
	private int casts_id;
	private int movie_id;
	
	
	@Override
	public String toString() {
		return "Casts [actorName=" + actor_name + ", actorLink=" + actor_link + ", actorImage=" + actor_image
				+ ", casts_id=" + casts_id + ", movie_id=" + movie_id + "]";
	}
	public String getActorName() {
		return actor_name;
	}
	public void setActorName(String actorName) {
		this.actor_name = actorName;
	}
	public String getActorLink() {
		return actor_link;
	}
	public void setActorLink(String actorLink) {
		this.actor_link = actorLink;
	}
	public String getActorImage() {
		return actor_image;
	}
	public void setActorImage(String actorImage) {
		this.actor_image = actorImage;
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
