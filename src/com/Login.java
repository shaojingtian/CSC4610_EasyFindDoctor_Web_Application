package com;

import java.io.*;
import java.sql.SQLException;
 


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
  
        UserDAO userDao = new UserDAO();
         
        try {
            User user = userDao.checkLogin(email, password);
            String destinationPage = "Login.jsp";
             
            if (user != null) {
                //HttpSession session = request.getSession();
                //session.setAttribute("user", user);
            	session.setAttribute("user", user);
            	session.setAttribute("userEmail", user.getEmail());
            	session.setAttribute("userName", user.getFullname());
            	session.setAttribute("userDob", user.getDob());
            	session.setAttribute("userGender", user.getGender().equals("f")==true ? "Female" : "Male");
            	session.setAttribute("userAddress", user.getMailingAddress());
            	
                destinationPage = "home.jsp";
            } else {
                String message = "Invalid email/password";
                session.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
            dispatcher.forward(request, response);
            
         
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}