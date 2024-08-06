import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entity.Feedback;
import entity.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private Connection getConnection() throws SQLException {
        // Replace with your database connection code
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            listProducts(req, resp);
        } else if (action.equals("detail")) {
            showProductDetail(req, resp);
        } else if (action.equals("feedback")) {
            showFeedbackForm(req, resp);
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Products")) {
            while (rs.next()) {
            	products.add(new Product(rs.getString("name"),rs.getDouble("price"),rs.getString("description")
                        ));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    private void showProductDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        Product product = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Products WHERE name = ?")) {
            stmt.setString(1, productName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	product = new Product(rs.getString("name"),rs.getDouble("price"),rs.getString("description")
                            );
                	
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Feedback> feedbackList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Feedback WHERE product_name = ?")) {
        	stmt.setString(1, productName);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    feedbackList.add(new Feedback(rs.getDate("date"), rs.getLong("customerId"), 
                    		rs.getString("productName"), rs.getString("feedback")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("product", product);
        req.setAttribute("feedbackList", feedbackList);
        req.getRequestDispatcher("/productDetail.jsp").forward(req, resp);
    }

    private void showFeedbackForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        req.setAttribute("productName", productName);
        req.getRequestDispatcher("/feedbackForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        LocalDateTime currentDateTime = LocalDateTime.now(); 

        if (action != null && action.equals("submitFeedback")) {
        	
        	req.setAttribute("todayDate", currentDateTime);
            submitFeedback(req, resp);
        }
    }

    private void submitFeedback(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    	
    	String productName = req.getParameter("name");
        String comment = req.getParameter("comment");
        Long customerId = Long.parseLong(req.getParameter("customerId"));
        Date date = (Date) formatter.parse(req.getParameter("todayDate"));

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Feedback (date, customerId, productName, feedback) VALUES (?, ?, ?, ?)")) {
            stmt.setDate(1, date);
            stmt.setLong(2, customerId);
        	stmt.setString(3, productName);
            stmt.setString(4, comment);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("product?action=detail&id=" + productName);
    }
}