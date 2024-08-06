<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
	User user = (User) session.getAttribute("loggedInUser");
	if(user != null) {%>
		Hello ${sessionScope.loggedInUser.getUsername()}, <a href="logoutAction.jsp"> Logout</a>
	<%}else{%>
		<a href="login.jsp"> Login</a>
	<%}
%>

<hr>
</body>
</html>