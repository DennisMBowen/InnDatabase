<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Database</title>
</head>
<body>
<form method = "post" action = "customerNavigationServlet">
<table>
<c:forEach items="${requestScope.allCustomers}" var="currentCustomer">
<tr>
	<td><input type = "radio" name = "id" value = "${currentCustomer.id}"></td>
	<td>${currentCustomer.firstName}</td>
	<td>${currentCustomer.lastName}</td>
	<td>${currentCustomer.phoneNumber}</td>
	<td>${currentCustomer.email}</td>
	<td>${currentCustomer.room.roomNumber}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Delete Customer from Database" name = "doThisToItem">
<input type = "submit" value = "Remove Hotel Room" name = "doThisToItem">
<input type = "submit" value = "View Hotel Rooms" name = "doThisToItem">
</form>

</body>
</html>