<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
	// Setup database connection
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	String FIND_QUERY ="SELECT * from user WHERE username = ? AND password = ?";
	
	String a = null;
	String b = null;
	boolean rememberMe = false;
	// Check if existing cookies from users - not logged out
	Cookie[] cookies = request.getCookies();
	boolean foundCookie = false;
	
	for(int i = 0; i < cookies.length; i++)
	{ 
	    Cookie c = cookies[i];
	    // If exist then can redirect to index.
	    if (c.getName().equals("cookieLoginUser"))
	    {	
	    	
	        a= c.getValue();
	        foundCookie = true;
	        //restore to another year
	        c.setMaxAge(60 * 60 * 24 * 365);
    		
	    }else if (c.getName().equals("cookieLoginPassword"))
	    {
	    	b= c.getValue();
	    	//restore to another year
	    	c.setMaxAge(60 * 60 * 24 * 365);
	    }
	} 
	
	if(!foundCookie) {
		a=request.getParameter("username");
		b=request.getParameter("password");
		String c=request.getParameter("rememberMe");
		if(c != null && c.equalsIgnoreCase("on")){
	    	rememberMe = true;
	    } 
	}
		

	    
	    PreparedStatement statement = con.prepareStatement(FIND_QUERY);
	    statement.setString(1,a);
	    statement.setString(2,b);
	    ResultSet rs = statement.executeQuery();
	    
	    boolean isUserExist = rs.next();
	    
	    if(isUserExist) {
	    	User user = new User(rs.getString("username"),rs.getString("password"),rs.getString("gender"),rs.getString("hobbies"),rs.getString("city"));
	    	session.setAttribute("loggedInUser", user);
	    	
	    	if (rememberMe) {        
	    		Cookie cookieUsername = new Cookie("cookieLoginUser", a);
	    		Cookie cookiePassword = new Cookie("cookieLoginPassword",b);
	    		
	    		// Make the cookie one year last
	    		cookieUsername.setMaxAge(60 * 60 * 24 * 365);
	    		cookiePassword.setMaxAge(60 * 60 * 24 * 365);
	    		response.addCookie(cookieUsername);
	    		response.addCookie(cookiePassword);
	    	}
	    	response.sendRedirect("index.jsp");
	    }else{
	    	response.sendRedirect("login.jsp?error=invalid");
	    }
	
%>
</body>
</html>