<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.* , java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, Admin <%-- <%out.println(session.getAttribute("username")); %> --%>!</h1>
    <a href="/Car-Servicing_Webapp/RetrieveCustomers">Show Customers</a>
    <br><br>
    <table>
    	<%
	    ResultSet res = (ResultSet) session.getAttribute("results");
    	
	    while (res!= null && res.next()){
	    	out.println("<tr>");
	    	out.println("<td>"+res.getString(1)+"</td>");
	    	out.println("<td>"+res.getString(2)+"</td>");
	    	out.println("<td>"+res.getString(4)+"</td>");
	    	out.println("</tr>");
	    }
	    %>
    </table>
    
    
</body>
</html>