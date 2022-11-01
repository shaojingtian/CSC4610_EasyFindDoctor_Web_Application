<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Search Result</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
th, tr, td, table {
	border: 1px solid red;
}
</style>
</head>
<body>
<%@ page import = "com.User, com.UserDAO, com.Login, com.SearchDoctor" %>
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
<form action="http://54.164.36.159/EasyFindDoctors/DoctorToAppointment" method="post">
   
    <caption><h3>List of doctors</h3></caption>
        <br>
        <table border="1" cellpadding="5">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Make an appointment</th>
             
            </tr>
            <c:forEach var="doctor" items="${key_list}">
                <tr>
                    <td><c:out value="${doctor.name}" /></td>
                    <td><c:out value="${doctor.email}" /></td>
                    <td><c:out value="${doctor.phone}" /></td>
                   <td><button name="doctorID" type="submit" value="${doctor.id}",  class = "btn btn-primary">Select</button></td>
                </tr>
            </c:forEach>
        </table>
  </div>
</div>
</div>
</body>
</html>

