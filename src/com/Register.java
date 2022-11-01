package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
	     String email = request.getParameter("email");
	     String fullname = request.getParameter("fullname");
	     String dob = request.getParameter("dob");
	     String gender = request.getParameter("gender");
	     String mailingAddress = request.getParameter("mailingAddress");
	     String password = request.getParameter("password");
	     
	     HttpSession session = request.getSession();

	     User user = new User();
	     user.setEmail(email);
	     user.setFullname(fullname);
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	     
	     try {
			user.setDob(formatter.parse(dob));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     user.setGender(gender);
	     user.setMailingAddress(mailingAddress);
	     user.setPassword(password);
	     
	     session.setAttribute("user", user);
     	 session.setAttribute("userEmail", user.getEmail());
     	 session.setAttribute("userName", user.getFullname());
     	 session.setAttribute("userDob", user.getDob());
     	 session.setAttribute("userGender", user.getGender());
     	 session.setAttribute("userAddress", user.getMailingAddress());

	     
	     
	     // JDBC driver name and database URL
	     String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	     //String DB_URL = "jdbc:mysql://52.26.86.130:3306/student";
	     String DB_URL = "jdbc:mysql://localhost:3306/finddoctors";

	     // Database credentials
	     String USER = "root";
	     String PASS = "";

	     Connection conn = null;
	     Statement stmt = null;
	     //STEP 2: Register JDBC driver
	  
	     try {
		 Class.forName("com.mysql.jdbc.Driver");
		 
	     //STEP 3: Open a connection
	     System.out.println("Connecting to database...");
		 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
		
	     //STEP 4: Execute a query
	     System.out.println("Creating statement...");
		 stmt = (Statement) conn.createStatement();
	     
		
	     String sql = "INSERT INTO patient (email, fullname, dob, gender, mailingAddress, password)" + "VALUES (\"" + email + "\", \"" + fullname + "\", \"" + dob + "\", \"" + gender + "\", \"" + mailingAddress + "\", \"" + password + "\");"; 
		 stmt.executeUpdate(sql);
		 
		 conn.close();
	     } catch (ClassNotFoundException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		 }
	     
	 
	     String destinationPage = "home.jsp";
	     RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
         dispatcher.forward(request, response);
         
     
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}

}