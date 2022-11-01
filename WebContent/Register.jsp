<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<a href="Login.jsp"><img src="logo.jpg" width="300" alt="Easy Find Doctors Logo"></a> 
<div class = "container">
<h2>Create a profile here:</h2>
  <form action="http://54.164.36.159/EasyFindDoctors/Register" method="post">
    <label>Email Address: <input name="email" type="email"></label>
    <br>
    <br>
    <label>Full Name: <input name="fullname" type="text"></label>
    <br>
    <br>
    <label>Date of Birth: <input name="dob" type="text"></label>
    <br> 
    <br>
    <label for="gender">Gender:</label>
    <select name = "gender" id="gender">
    <option value = "m">Male</option>
    <option value = "f">Female</option>
    <option value = "o">Other</option>
    </select>
    <br>
    <br>
    <label>Mailing Address:
    <br>
    <br>
    <textarea name="mailingAddress"></textarea> 
    </label>
    <br>
    <br>
    <label>Password: <input name="password" type="text"></label>
    <br>
    <br>
    <button type="submit" class = "btn btn-primary">Create Account</button>
  </form>
  </div>
  
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>