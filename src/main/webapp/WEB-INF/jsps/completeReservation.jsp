<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete reservation</title>
</head>
<body>
	<h2>Complete reservation</h2>
	Airline: ${flight.operatingAirlines}<br />
	Departure City: ${flight.departureCity}<br />
	Arrival City: ${flight.arrivalCity}<br />

	<form action="completeReservation" method="post">
		<pre>
	Passenger details:
	First name:<input type="text" name="passengerFirstName" /> 
	Last name:<input type="text" name="passengerLastName" />
	Email:<input type="text" name="passengerEmail" />
	Phone:<input type="text" name="passengerPhone" />
	
	Card details:
	Name on card:<input type="text" name="nameOnTheCard" />
	Card Number:<input type="text" name="cardNumber" />
	Expiration Date:<input type="text" name="expirationDate" />
	Security Code:<input type="text" name="securityCode" />
	
	<input type="hidden" name="flightId" value="${flight.id} }" />
	<input type="submit" value="confirm" />
	</pre>
	</form>
</body>
</html>