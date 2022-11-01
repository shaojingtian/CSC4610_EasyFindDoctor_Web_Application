
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
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchDoctor")
public class SearchDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public SearchDoctor() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		List<Map> list =new ArrayList<Map>();//Create a list collection for key-value pairs stored in a map
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/finddoctors";
		String USER = "root";
		String PASS = "";
		Connection conn = null;
		Statement st = null;
		
		String docSpecialty = request.getParameter("specialty");
		String docInsurance = request.getParameter("insurance");
		String docLocation = request.getParameter("location");
		String docGender = request.getParameter("gender");
	    String docID_string = null;
	    String docName = null;
	    String docEmail = null;
	    String docPhone = null;
	
		
		try {
			Class.forName(JDBC_DRIVER);// Loading mysql driver class
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// Drivers create connections using driver addresses, database usernames, and passwords
			st = conn.createStatement();
			
			String sql ="SELECT id, fullName, email, phone\r\n"+
					"FROM doctors d, doctor_accept_insurance i\r\n"+
					"WHERE d.id = i.doctorId\r\n"+
					"AND d.specialty = \"" + docSpecialty + "\"\r\n"+
					"AND d.location = \"" + docLocation + "\"\r\n"+
					"AND d.gender = \"" + docGender + "\"\r\n"+
					"AND i.insuranceId = \"" + docInsurance + "\";";
					
			
			ResultSet rs = st.executeQuery(sql);
			//The content read from the database returns a result set.
			System.out.println("get data");
			while (rs.next()) {
				docID_string = rs.getString("id");
				docName = rs.getString("fullName");
				docEmail = rs.getString("email");
				docPhone = rs.getString("phone");
				//Get table information for receiving database by loop
				
				Map map = new HashMap();
				map.put("id", docID_string);
				map.put("name", docName);			
				map.put("email", docEmail);		
				map.put("phone", docPhone);
				//Store key-value pairs in map sets
				System.out.println(map);
				list.add(map);//Save the map collection object into the list collection
				System.out.println("Put in collection");
				for (Map map_1 :list) {
					System.out.println(map_1);
				}//Go through the data at the printing desk to see if there are any errors
				
			}//Traversal result set
			
     		//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	

		System.out.println("Jump");
		String destinationPage = "searchDoctorResult.jsp";
		request.setAttribute("key_list",list);//Put list collection data into request for sharing

		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}