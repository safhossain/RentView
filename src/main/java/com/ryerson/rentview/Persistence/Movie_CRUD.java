package com.ryerson.rentview.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ryerson.rentview.Helper.MovieInfo;

public class Movie_CRUD extends Base_CRUD{    
    
    /************************************* CRUD OPERATIONS ********************************************/ 
    public static void createMovie(String movieName, int releaseYear, double rentalCost, String movieImagePath, boolean isMovieFeatured) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MOVIE (movie_name, release_year, rental_cost, movie_image_path, is_movie_featured) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, movieName);
            pstmt.setInt(2, releaseYear);
            pstmt.setDouble(3, rentalCost);
            pstmt.setString(4, movieImagePath);
            pstmt.setBoolean(5, isMovieFeatured);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e);
        }
    }
    
    public static MovieInfo readMovie(int movieId) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MOVIE WHERE movie_ID = ?");
            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Create and return a MovieInfo object
                return new MovieInfo(
                    rs.getInt("movie_ID"),
                    rs.getString("movie_name"),
                    rs.getInt("release_year"),
                    rs.getDouble("rental_cost"),
                    rs.getString("movie_image_path"),
                    rs.getBoolean("is_movie_featured")
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Query failed: " + e);
        }
        return null;
    }
    
    public static void updateMovie(int movieId, String attributeName, Object newValue) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE MOVIE SET " + attributeName + " = ? WHERE movie_ID = ?");
            if (newValue instanceof String) {
                pstmt.setString(1, (String) newValue);
            } else if (newValue instanceof Integer) {
                pstmt.setInt(1, (Integer) newValue);
            } else if (newValue instanceof Double) {
                pstmt.setDouble(1, (Double) newValue);
            } else if (newValue instanceof Boolean) {
                pstmt.setBoolean(1, (Boolean) newValue);
            }
            pstmt.setInt(2, movieId);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("Update failed: " + e);
        }
    }
    
    public static void deleteMovie(int movieId) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM MOVIE WHERE movie_ID = ?");
            pstmt.setInt(1, movieId);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e);
        }
    }
    
    public static void main(String[] args) {
        int testMovieId = 1;
        Connection con = getCon();
        if (con != null) {
            try {
                System.out.println(readMovie(testMovieId).toString());
                con.close();
            } catch (SQLException e) {
                System.out.println("con is NULL: " + e);
            }
        }
    }
}

