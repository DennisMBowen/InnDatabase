<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel Lodge Rooms</title>
</head>
<body>

<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allRooms}" var="currentroom">
<tr>
	<td><input type ="radio" name ="id" value="${currentroom.id}"></td>
	<td>${currentroom.roomNumber}</td>
	<td>${currentroom.numberOfBeds}</td>
	<td>${currentroom.bedSize}</td>
	<td>${currentroom.guest.firstName}</td>
	<td>${currentroom.guest.lastName}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Delete Room" name = "doThisToItem">
<input type = "submit" value = "Add Room" name = "doThisToItem">
<input type = "submit" value = "Modify Room" name = "doThisToItem">
<input type = "submit" value = "Add Guest" name = "doThisToItem">
<input type = "submit" value = "Remove Guest" name = "doThisToItem">
<input type = "submit" value = "View Customer Database" name = "doThisToItem">
</form>

</body>
</html>