<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session.removeAttribute("loggedInUser");

	// OR to remove all objects that are bound to that session;
	// session.invalidate();
	response.sendRedirect("index.jsp");
%>
</body>
</html>