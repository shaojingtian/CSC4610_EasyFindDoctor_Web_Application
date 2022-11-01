package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorToAppointment
 */
@WebServlet("/DoctorToAppointment")
public class DoctorToAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorToAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_string = request.getParameter("doctorID");
		Doctor doctor = new Doctor();
		HttpSession session = request.getSession();
	     
	     String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	     String DB_URL = "jdbc:mysql://localhost:3306/finddoctors";
	     String USER = "root";
	     String PASS = "";

	     Connection conn = null;
	     Statement stmt = null;
	   
	  
	     try {
		 Class.forName("com.mysql.jdbc.Driver");
		 
	     System.out.println("Connecting to database...");
		 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
		
	     System.out.println("Creating statement...");
		 stmt = (Statement) conn.createStatement();
	     
	     String sql = "SELECT * FROM doctors WHERE id = \"" + id_string + "\";"; 
		 ResultSet rs = (ResultSet) stmt.executeQuery(sql);
	 
	        while (rs.next()) {
	            doctor.setId(Integer.parseInt(id_string));
	            doctor.setFullname(rs.getString("fullName"));          
	        }		 
		 
	        
	     } catch (ClassNotFoundException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		 }
	     
	     session.setAttribute("doctor", doctor);
	     session.setAttribute("docId", doctor.getId());
	     session.setAttribute("docName", doctor.getFullname());
	 
	     String destinationPage = "makeAppointment.jsp";
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
