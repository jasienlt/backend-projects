<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation - 2</title>
</head>
<body>
<h1> JSP - Confirmation </h1>
<form action="register" method="POST">
	
	<p>Username: ${param.username}</p><br>
	<input type="text" name="username" value=${param.username} hidden=true>
	
	<p>Password: ${param.password}</p><br>
	<input type="password" name="password" value=${param.password} hidden=true>
	
	<p>Gender: ${param.gender}</p><br>
	<input type="text" name="gender" value=${param.gender} hidden=true>
	
	<%
		String[] hobbies = request.getParameterValues("hobbies");
		String all_hobbies = hobbies[0];
		for (int i=1; i<hobbies.length; i++) {
			all_hobbies += ',' + hobbies[i];
		}
	%>
	<p>Hobbies: <%=all_hobbies%></p><br>
	<input type="hobbies" name="hobbies" value=<%=all_hobbies%> hidden=true>
	
	<p>City: ${param.city}</p><br>
	<input type="city" name="city" value=${param.city} hidden=true>
	
	<button type="submit" value="submit"> Confirmed </button>
</form>

</body>


</html>