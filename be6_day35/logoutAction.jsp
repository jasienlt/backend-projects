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

	// Kill cookie
	Cookie[] cookies = request.getCookies();
		boolean foundCookie = false;
		
		for(int i = 0; i < cookies.length; i++)
		{ 
		    Cookie c = cookies[i];
		    // If exist then can redirect to index.
		    if (c.getName().equals("cookieLoginUser"))
		    {	
		        c.setMaxAge(0);
		    }else if (c.getName().equals("cookieLoginPassword"))
		    {
		    	c.setMaxAge(0);
		    }
		} 
	response.sendRedirect("index.jsp");
%>
</body>
</html>
