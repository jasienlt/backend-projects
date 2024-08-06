package be06_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    //create the query
    private static final String INSERT_QUERY ="insert into user(username, password, gender, hobbies, city) values(?,?,?,?,?);";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter out = res.getWriter();
        //set Content type
        res.setContentType("text/hmtl");
        //read the form values
        String a=request.getParameter("username");
        String b=request.getParameter("password");
        String c=request.getParameter("gender");
        String d=request.getParameter("hobbies");
        String e1=request.getParameter("city");

        //load the jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //create the connection
        try(
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set the values
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

        }catch(SQLException se) {
        	out.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            out.println(e.getMessage());
            e.printStackTrace();
        }

        //close the stream
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }
}