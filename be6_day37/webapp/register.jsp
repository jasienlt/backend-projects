<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
    
</head>
<body>
<h1>Register form</h1>

<form id="register" method="POST" action="confirm.jsp">

	<label for="username">Username:</label><br>
	<input type="text" id="username" name="username"><br><br>
	
	<label for="password">Password:</label><br>
	<input type="password" id="password" name="password"><br><br>
	
	<label>Gender:</label><br>
	<input type="radio" id="male" name="gender" value="male">
	<label for="male">Male</label><br>
	<input type="radio" id="female" name="gender" value="female">
	<label for="female">Female</label><br><br>
	
	<label>Hobbies:</label><br>
	<input type="checkbox" id="music" name="hobbies" value="music">
	<label for="music">Music</label><br>
	<input type="checkbox" id="sport" name="hobbies" value="sport">
	<label for="sport">Sport</label><br>
	<input type="checkbox" id="reading" name="hobbies" value="reading">
	<label for="reading">Reading</label><br><br>
	
	<label for="city">City:</label><br>
	<select id="city" name="city">
		<option value="HCM">HCM</option>
		<option value="HN">HN</option>
		<option value="MEL">MEL</option>
	</select><br><br>
	
	<button type="submit">Submit</a></button>
	<output id="output"></output>
</form>
<%
	String a=request.getParameter("username");
	String b=request.getParameter("password");
	String c=request.getParameter("gender");
	String d=request.getParameter("hobbies");
	String e1=request.getParameter("city");
	
	String INSERT_QUERY ="insert into user(username, password, gender, hobbies, city) values(?,?,?,?,?);";
	

//load the jdbc driver
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
        PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
        
        ps.setString(1,a);
		ps.setString(2,b);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.setString(5,e1);
		int x = ps.executeUpdate();
		
		if(x>0){
			out.println("Record successfully inserted");
		}else{
			out.println("Registration failed");
		}
		
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch(SQLException se) {
		out.println(se.getMessage());
	    se.printStackTrace();
	} catch(Exception e) {
	    out.println(e.getMessage());
	    e.printStackTrace();
	}

	
	//close the stream
		
%>
</body>
</html>