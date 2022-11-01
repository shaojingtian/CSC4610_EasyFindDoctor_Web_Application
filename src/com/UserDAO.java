package com;

import java.io.PrintWriter;
import java.sql.*;


public class UserDAO {
 
    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
    	
        String jdbcURL = "jdbc:mysql://localhost:3306/finddoctors";
        String dbUser = "root";
        String dbPassword = "";
 
        Connection conn = null;
	    Statement stmt = null;
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Connecting to database...");
	    conn = (Connection) DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
	
	    System.out.println("Creating statement...");
	    stmt = (Statement) conn.createStatement();
	    String sql = "SELECT * FROM patient WHERE email = \"" + email + "\" AND password = \"" + password + "\";";
	    ResultSet rs = (ResultSet) stmt.executeQuery(sql);
         
 
        User user = null;
 
        if (rs.next()) {
            user = new User();
            user.setEmail(rs.getString("email"));
            user.setFullname(rs.getString("fullname"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getString("gender"));
            user.setMailingAddress(rs.getString("mailingAddress"));
            user.setPassword(rs.getString("password"));
            
            
        }
 
        conn.close();
 
        return user;
    }
}
