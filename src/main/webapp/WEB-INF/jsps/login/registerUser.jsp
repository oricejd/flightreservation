<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
	<h2>User Registration</h2>
	<form action="reqisterUser" method="post">

		<pre>
		First Name: <input type="text" name="firstName" /> 
		Last Name: <input type="text" name="lastName" />
		User Name: <input type="text" name="email" />
		Password: <input type="password" name="password" />
		Confirm Password: <input type="password" name="confirmPassword" />
		<input type="submit" value="register" />
		</pre>
	</form>

</body>
</html>