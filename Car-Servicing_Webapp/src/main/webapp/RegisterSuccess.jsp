<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome, <%out.println(session.getAttribute("name")); %>! Your registration is Successful!</h3>
	<br><br>
	<input type="button" value="Back to Login" onclick="window.location.href = 'index.html';">
</body>
</html>