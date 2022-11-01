<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%@ page import = "com.User, com.UserDAO, com.Login" %>
<a href="home.jsp"><img src="logo.jpg" width="300" alt="Easy Find Doctors Logo"></a> 

<div class="container">
  <h2>Welcome <%= session.getAttribute("userName") %>!</h2>
  <br>
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
    <button type="submit", class = "btn btn-light">Logout</button>
  </form>  
   </div>
 
 <div class = "col-8">
  <h3>Find a provider</h3>
  <br>
  <form action="http://54.164.36.159/EasyFindDoctors/SearchDoctor" method="post">
    <label for="specialty">Choose a doctor's specialty:</label>
    <select name = "specialty" id="specialty">
    <option value = 0>Internal Medicine</option>
    <option value = 1>Pediatrics</option>
    <option value = 2>OB/GYN</option>
    <option value = 3>Cardiologist</option>
    <option value = 4>Surgery</option>
    <option value = 5>Dermatology</option>
    <option value = 6>Otolaryngology</option>
    <option value = 7>Oncology</option>
    
    </select>
    <br>
    <br>
    <label for="insurance">Choose an insurance:</label>
    <select name = "insurance" id="insurance">
    <option value = 0>Aetna Choice POS II</option>
    <option value = 1>Aetna HMO</option>
    <option value = 2>Aexcel PPO</option>
    <option value = 3>BCBS Blue Card PPO</option>
    <option value = 4>BCBS LA BlueConnect HMO POS</option>
    <option value = 5>BCBS LA Preferred Care PPO</option>
    <option value = 6>Humana Choice POS</option>
    <option value = 7>First Health PPO</option>
    <option value = 8>Multiplan PPO</option>
    <option value = 9>UHC Navigate HMO</option>
    </select>
    <br>
    <br>
    <label for="location">Choose a location:</label>
    <select name = "location" id="location">
    <option value = 0>Central</option>
    <option value = 1>Mid City</option>
    <option value = 2>BlueBonnet</option>
    <option value = 3>Perkins</option>
    <option value = 4>Southdowns</option>
    </select>
    <br>
    <br>
    <label for="gender">Choose a doctor's gender:</label>
    <select name = "gender" id="gender">
    <option value = 1>Male</option>
    <option value = 0>Female</option>
    </select>
    <br>
    <br>
    <button type="submit", class = "btn btn-primary">Display</button>
  </form>
    </div>
  </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>  

</body>
</html>