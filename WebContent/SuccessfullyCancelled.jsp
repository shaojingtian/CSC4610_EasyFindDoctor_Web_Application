<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully cancelled appointment</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%@ page import = "com.Doctor" %>
<a href="home.jsp"><img src="logo.jpg" width="300" alt="Easy Find Doctors Logo"></a> 

<div class = "container">
 <div class = "row">
 <div class = "col-4">  
    <br>
    <br>
    <br>
  <form action="http://54.164.36.159/EasyFindDoctors/ToProfile" method="post">
    <button type="submit", class = "btn btn-info">View my profile</button>
  </form>
    <br>
    <br> 
    <br> 
  <form action="http://54.164.36.159/EasyFindDoctors/GetAppointments" method="post">
    <button type="submit", class = "btn btn-info">View my appointments</button>
  </form>
    <br>
    <br> 
    <br> 
  <form action="http://54.164.36.159/EasyFindDoctors/Logout" method="post">
    <button type="submit", class = "btn btn-light">Log out</button>
  </form> 
  </div> 
  <div class = "col-8">
  <h4>You have cancelled the appointment with Dr. <%= session.getAttribute("cancelDocName") %> on <%= session.getAttribute("cancelDate") %> at <%= session.getAttribute("cancelTime") %>. </h4>
  <br>
  </div>
  </div>  
  </div>
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
</body>
</html>