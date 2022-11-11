<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Add New Customer</title>
	<script defer src="add-customer.js"></script>
</head>
<body>
 <div id ="error"></div>
 <form id = form action = "addCustomerServlet" method = "post">
<div>
	<label for= "firstName">First Name: </label>
	<input id = "firstName" name = "firstName" type = "text">
	<label for= "lastName">Last Name: </label>
	<input id = "lastName" name = "lastName" type = "text">
	<label for="phoneNumber">Phone Number: </label>
	<input id = "phoneNumber" name = "phoneNumber" type = "text">
	<label for="email">Email: </label>
	<input id = "email" name = "email" type = "text">
</div>
 <input type = "hidden" name = "id" value="${guestRoom.id}">
 <input type = "submit" value = "Add Customer">
 </form> <br />
 <a href="viewAllRoomsServlet"> Back to Hotel Rooms</a>
</body>
</html>