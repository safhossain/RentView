package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Member_CRUD {
    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RENTVIEW?autoReconnect=true&useSSL=false", "root", "student");            
        } catch (Exception e) {
            System.out.println("CONNECTION failed: " + e);
        }
        return con;
    }
    
    public static void createMember(String email, String password, String firstName, String lastName, String dob) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MEMBER (email_address, hashed_password, first_name, last_name, date_of_birth) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, dob);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e);
        }
    }
    
    public static void readMember(String email) {
        Connection con = getCon();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE email_address = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Query failed: " + e);
        }
    }

    public static void main(String[] args) {
        Connection con = getCon();
        
        if (con != null) {
            try {
                //createMember("safhossain338@gmail.com", "whatUpBro123", "Safwan", "Hossain", "2002-10-22");
                readMember("john.doe@example.com");
                con.close();
            } catch (SQLException e) {
                System.out.println("con is NULL: " + e);
            }
        }
    }
}