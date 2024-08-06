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
	if(session.getAttribute("loggedInUser") != null) {
		response.sendRedirect("index.jsp");
	}

	String error = request.getParameter("error");
	if(error != null){
		out.println(error);
	}
%>

<form id="login" method="POST" action="loginAction.jsp">
	<label for="username">Username:</label><br>
	<input type="text" id="username" name="username"><br><br>
	
	<label for="password">Password:</label><br>
	<input type="password" id="password" name="password"><br><br>
	
	<input type="checkbox" name="rememberMe">
	<label for="checkbox">Keep me logged in</label>
	
	<input type="submit" value="Login">
</form>
</body>
</html>