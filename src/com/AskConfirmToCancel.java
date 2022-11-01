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
 * Servlet implementation class AskConfirmToCancel
 */
@WebServlet("/AskConfirmToCancel")
public class AskConfirmToCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskConfirmToCancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appointmentId_string = request.getParameter("appointmentId");
		HttpSession session = request.getSession();
	     
	     String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	     String DB_URL = "jdbc:mysql://localhost:3306/finddoctors";
	     String USER = "root";
	     String PASS = "";

	     Connection conn = null;
	     Statement stmt = null;
	     String appointmentDocName = null;
	     String appointmentDate = null;
	     String appointmentTime = null;
	   
	  
	     try {
		 Class.forName("com.mysql.jdbc.Driver");
		 
	     System.out.println("Connecting to database...");
		 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
		
	     System.out.println("Creating statement...");
		 stmt = (Statement) conn.createStatement();
		 

		 String sql ="SELECT a.appointment_date, a.appointment_time, d.fullName\r\n"+
					"FROM appointment a, doctors d\r\n"+
					"WHERE d.id = a.doctor_id\r\n"+
					"AND a.appointment_id = \"" + appointmentId_string + "\";";
					
			ResultSet rs = stmt.executeQuery(sql);
			//The content read from the database returns a result set.
			System.out.println("get data");
			while (rs.next()) {
				appointmentDocName = rs.getString("fullName");
				appointmentDate = rs.getString("appointment_date");
				appointmentTime = rs.getString("appointment_time");
				//Get table information for receiving database by loop
			}
			session.setAttribute("cancelAppointmentId", appointmentId_string);
			session.setAttribute("cancelDocName", appointmentDocName);
		    session.setAttribute("cancelDate", appointmentDate);
		    session.setAttribute("cancelTime", appointmentTime);
			
	        
	     } catch (ClassNotFoundException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		 }
	    
	 
	     String destinationPage = "askConfirmToCancel.jsp";
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
