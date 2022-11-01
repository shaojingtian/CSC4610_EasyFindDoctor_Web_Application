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
 * Servlet implementation class CancelAppointment
 */
@WebServlet("/CancelAppointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String appointmentId = (String)session.getAttribute("cancelAppointmentId");
		
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
		 

				
		 String sql ="UPDATE appointment\r\n"+
					"SET status_booked = \"N\"\r\n"+
					"WHERE appointment_id = \"" + appointmentId + "\";";
     	 stmt.executeUpdate(sql);
     	 
     	 sql ="UPDATE appointment\r\n"+
 					"SET patient_email = \"Null\"\r\n"+
 					"WHERE appointment_id = \"" + appointmentId + "\";";
 					
     	 stmt.executeUpdate(sql);	 
	        
	     } catch (ClassNotFoundException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		 }
	    
	 
	     String destinationPage = "SuccessfullyCancelled.jsp";
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
