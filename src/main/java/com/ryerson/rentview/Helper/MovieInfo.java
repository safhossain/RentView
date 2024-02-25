package com.ryerson.rentview.Helper;

public class MovieInfo {
    private int movieID;
    private String movieName;
    private int releaseYear;
    private double rentalCost;
    private String movieImagePath;
    private boolean isMovieFeatured;

    public MovieInfo(int movieID, String movieName, int releaseYear, double rentalCost, String movieImagePath, boolean isMovieFeatured) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.rentalCost = rentalCost;
        this.movieImagePath = movieImagePath;
        this.isMovieFeatured = isMovieFeatured;
    }

    // Getters
    public int getMovieID() {
        return movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public String getMovieImagePath() {
        return movieImagePath;
    }

    public boolean isMovieFeatured() {
        return isMovieFeatured;
    }

    // Setters
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public void setMovieImagePath(String movieImagePath) {
        this.movieImagePath = movieImagePath;
    }

    public void setMovieFeatured(boolean isMovieFeatured) {
        this.isMovieFeatured = isMovieFeatured;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalCost=" + rentalCost +
                ", movieImagePath='" + movieImagePath + '\'' +
                ", isMovieFeatured=" + isMovieFeatured +
                '}';
    }
}

