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
import com.DoctorToAppointment;

/**
 * Servlet implementation class MakeAppointment
 */
@WebServlet("/MakeAppointment")
public class MakeAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String date = request.getParameter("date");
	     String time = request.getParameter("time");
	     HttpSession session = request.getSession();
	     String doctorID = Integer.toString((Integer)session.getAttribute("docId"));
	     String email = (String)session.getAttribute("userEmail");
	     String destinationPage = "makeAppointment.jsp";
	     System.out.println(doctorID);
	     
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
	     
		
		 String sql ="SELECT status_booked\r\n"+
					"FROM appointment\r\n"+
					"WHERE doctor_id = \"" + doctorID + "\"\r\n"+
					"AND appointment_date = \"" + date + "\"\r\n"+
					"AND appointment_time = \"" + time + "\";";
		 
		 ResultSet rs = (ResultSet) stmt.executeQuery(sql);
		 while (rs.next()) {
	            if (rs.getString("status_booked").equals("Y")==true) {
	            	String message = "The selected date and time is not available, please choose another date or time";
	                session.setAttribute("message", message);
	            }
	            else {
	            	sql ="UPDATE appointment\r\n"+
	    					"SET status_booked = \"Y\"\r\n"+
	    					"WHERE doctor_id = \"" + doctorID + "\"\r\n"+
	    					"AND appointment_date = \"" + date + "\"\r\n"+
	    					"AND appointment_time = \"" + time + "\";";
	            	 stmt.executeUpdate(sql);
	            	 
	            	 sql ="UPDATE appointment\r\n"+
		    					"SET patient_email = \"" + email + "\"\r\n"+
		    					"WHERE doctor_id = \"" + doctorID + "\"\r\n"+
		    					"AND appointment_date = \"" + date + "\"\r\n"+
		    					"AND appointment_time = \"" + time + "\";";
	            	 stmt.executeUpdate(sql);
	            	 
	            	 session.setAttribute("date", date);
	            	 session.setAttribute("time", time);
	            	 destinationPage = "SuccessfulBooked.jsp";            	 
	            }
	        }		 
		 	
	     } catch (ClassNotFoundException | SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		 }
	     
	 
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
