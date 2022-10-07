<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Customer</title>
</head>
<body>
 <form action = "addCustomerServlet" method = "post">
 First Name: <input type = "text" name = "firstName">
 Last Name: <input type = "text" name = "lastName">
 Phone Number: <input type = "text" name = "phoneNumber">
 Email Address: <input type = "text" name = "email">
 <input type = "hidden" name = "id" value="${guestRoom.id}">
 <input type = "submit" value = "Add Customer">
 </form> <br />
 <a href="viewAllRoomsServlet"> Back to Hotel Rooms</a>
</body>
</html>