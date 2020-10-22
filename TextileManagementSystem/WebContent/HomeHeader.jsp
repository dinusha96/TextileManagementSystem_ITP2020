<!-- 
	ITP 2020 Textile Management System
	
	@author V. Yahdhursheika - IT19186948

 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.container {
		background-color: #052B6A;
		width:100%;
		height:150px;
	}
	
.logo {
 	 	border-radius: 4px;
  		padding: 8px;
  		width: 200px;
		float: left;
  		padding-left: 10px;
  		height: 130px;
	}

h1 {
		color: #fff;
		font-size: 50px;
		font-family: "Times New Roman", Times, serif;
		text-align: left;
		margin-top: 0px;
		float: left;
		margin: 0px;
		line-height: 130px;
		padding-left: 10%;
	}
hr {
		width: 100%;
	}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 20px;
  font-family: "Times New Roman", Times, serif;
  color: white;
  text-align: center;
  padding: 12px 60px;
  text-decoration: none;
}

.navbar a:hover {
  background-color: #d5eaff;
  color: black;
  font-weight: bold;
  font-family: "Times New Roman", Times, serif;
  font-size: 20px;
}
</style>
</head>
<body>

	<div class="container">
			<a href="index.jsp"><img src="images/logo.jpg" alt="Logo" class="logo"></a>
			<a href="index.jsp"><h1>World of Fashion</h1></a>
			<br><br><br><br><br><br><br>
	</div>
	
		<hr>


	<div class="navbar">
  		<a href="index.jsp">Home</a>
  		<a href="#">About Us</a>
  		<a href="ContactUs.jsp">Contact Us</a>
  		<a href="#">Register</a>
  		<a href="Login.jsp">Login</a>
  		<a href="#"><i class="w3-xxlarge fa fa-shopping-cart"></i></a>
  		
  	</div>
  	
</body>
</html>