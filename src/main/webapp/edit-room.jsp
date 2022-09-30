<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Room</title>
</head>
<body>
	<form action ="editRoomServlet" method="post">
	Number Of Beds: <input type ="text" name = "numberOfBeds" value="${roomToEdit.numberOfBeds}">
	Bed Size: <input type ="text" name = "bedSize" value="${roomToEdit.bedSize}">
	<input type = "hidden" name = "id" value="${roomToEdit.id}">
	<input type = "submit" value = "Save Edited Room">
	</form>
</body>
</html>