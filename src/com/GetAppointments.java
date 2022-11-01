package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAppointments
 */
@WebServlet("/GetAppointments")
public class GetAppointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAppointments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		 String DB_URL = "jdbc:mysql://localhost:3306/finddoctors";
		 String USER = "root";
		 String PASS = "";
		 Connection conn = null;
		 
		 Statement st = null;
		 String appointmentId_string = null;
		 String docId_string = null;
		 String docName = null;
		 String appointmentDate = null;
		 String appointmentTime = null;
		 
		 try {
				Class.forName(JDBC_DRIVER);// Loading mysql driver class
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Creating statement...");
				st = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 
		 List<Map> list =new ArrayList<Map>();
		 HttpSession session = request.getSession();
		 String userEmail = (String)session.getAttribute("userEmail");
		 System.out.println(userEmail);
		 
			
			try {
				String sql ="SELECT a.appointment_id, a.doctor_id, a.appointment_date, a.appointment_time, d.fullName\r\n"+
						"FROM appointment a, doctors d\r\n"+
						"WHERE d.id = a.doctor_id\r\n"+
						"AND a.patient_email = \"" + userEmail + "\"\r\n"+
						"AND a.status_booked = \"Y\";";
						
				ResultSet rs = st.executeQuery(sql);
				//The content read from the database returns a result set.
				System.out.println("get data");
				while (rs.next()) {
					appointmentId_string = rs.getString("appointment_id");
					docId_string = rs.getString("doctor_id");
					docName = rs.getString("fullName");
					appointmentDate = rs.getString("appointment_date");
					appointmentTime = rs.getString("appointment_time");
					//Get table information for receiving database by loop
					
					Map map = new HashMap();
					map.put("appointmentId", appointmentId_string );	
					map.put("appointmentDocId", docId_string );	
					map.put("appointmentDocName", docName);			
					map.put("appointmentDate", appointmentDate);		
					map.put("appointmentTime", appointmentTime);
					//Store key-value pairs in map sets
					System.out.println(map);
					list.add(map);//Save the map collection object into the list collection
					System.out.println("Put in collection");
					for (Map map_1 :list) {
						System.out.println(map_1);
					}//Go through the data at the printing desk to see if there are any errors
					
				}//Traversal result set
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		

			System.out.println("Jump");
			String destinationPage = "getAppointment.jsp";
			request.setAttribute("appointment_list",list);//Put list collection data into request for sharing

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
