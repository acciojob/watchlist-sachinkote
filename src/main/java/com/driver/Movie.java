package com.driver;

public class Movie {
	//String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters
private String name;
private int durationInMinutes;
private double imdbRating;
public Movie() {
	super();
}
public Movie(String name, int durationInMinutes, double imdbRating) {
	super();
	this.name = name;
	this.durationInMinutes = durationInMinutes;
	this.imdbRating = imdbRating;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDurationInMinutes() {
	return durationInMinutes;
}
public void setDurationInMinutes(int durationInMinutes) {
	this.durationInMinutes = durationInMinutes;
}
public double getImdbRating() {
	return imdbRating;
}
public void setImdbRating(double imdbRating) {
	this.imdbRating = imdbRating;
}

}
