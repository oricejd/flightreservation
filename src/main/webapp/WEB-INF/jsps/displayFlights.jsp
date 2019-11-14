<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Flights</h2>
	<table>
		<tr>
			<th>Airlines</th>
			<th>Departure City</th>
			<th>Departure Time</th>
		</tr>
	</table>
	<c:forEach items="${flights}">


	</c:forEach>
</body>
</html>