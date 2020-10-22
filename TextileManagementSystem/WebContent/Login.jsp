<!-- 
	ITP 2020 Textile Management System
	
	@author V. Yahdhursheika - IT19186948

 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.itp.model.*" %>
<%@ page import="com.itp.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
	background: url("images/bg1.jpg");     
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
	}

	h2 {
	color: #052B6A;
	text-align: center;
	font-size: 30px;
	}
	
	.login_container {
			padding: 16px;
			background-color: white;
			margin-left: 25%;
			margin-right: 25%;
			margin-top: 0%;
		}
		.hrStyles {
			width: 55%;
		}
		
	input[type=text], input[type=password], input[type=number], input[type=email]
	{
			width: 90%;
			font-family: Arial, Helevetica, sans-serif;
			padding: 15px;
			display: inline-block;
			border: none;
			background: #e6e6ff;
	}

	input[type=text]:focus, input[type=password]:focus, input[type=number]:focus, 
		input[type=email]:focus {
			background-color: #d5eaff;
			outline: none;
	}
		.select {
			width: 95%;
			font-family: Arial, Helevetica, sans-serif;
			padding: 15px;
			display: inline-block;
			border: none;
			background: #e6e6ff;
		}
		.select:focus {
			background-color: #d5eaff;
			outline: none;
		}
		#submit {
			background-color: blue;
			color: white;
			font-size: 20px;
			font-family: "Times New Roman", Times, serif;
			padding: 20px 100px;
			border: none;
			text-align: center;
			margin-left: 30%;
		}
		#submit:hover {
			background-color: pink;
			outline: none;
			font-weight: bold;
			font-size: 24px;
		}
		#reset {
			background-color: red;
			color: white;
			padding: 16px 20px;
			border: none;
		}
		#reset:hover {
			background-color: pink;
			outline: none;
		}
		.forgot {
			float: right;
			font-family: "Times New Roman", Times, serif;
			font-size: 16px;
			font-weight: bold;
			font-style: italic;
		}
		.forgot:hover {
			float: right;
			font-family: "Times New Roman", Times, serif;
			font-size: 18px;
			color: red;
		}
</style>
</head>
<body>

	<jsp:include page="HomeHeader.jsp"></jsp:include>
	
	<h2>Login</h2>
	<hr class="hrStyles">
	
	
	<div class="login_container">
	<form action="Login_Servlet" method="post">
	
		<label>Enter User Email</label><br><br>
		<input type="email" name="email" placeholder="Enter User Email" required><br><br><br>
		
		<label>Enter Password</label><br><br>
		<input type="password" name="password" placeholder="Enter Password" required><br><br><br>
		
		<label>Select User Type</label><br><br>
		<select class="select" name="userType" required>
				<option value="customer">Customer</option>
				<option value="supplier">Supplier</option>
				<option value="admin">Admin</option>
		</select><br><br><br>
		
		<a href="#" class="forgot">Forgot Password ?</a><br>
		<input type="submit" value="Log In" id="submit">

	</form>
	<br>
	</div>
	
	<br><br><br>
	
	<jsp:include page="HomeFooter.jsp"></jsp:include>
</body>
</html>