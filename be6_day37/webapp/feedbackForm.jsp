<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Leave Feedback</title>
</head>
<body>
    <h1>Leave Feedback for Product ID ${productId}</h1>
    <form action="product" method="post">
        <input type="hidden" name="action" value="submitFeedback">
        <input type="hidden" name="date" value="${todayDate}">
        <input type="hidden" name="customerId" value="${customerId}">
        <input type="hidden" name="productName" value="${productName}">
        <textarea name="comment" rows="4" cols="100"></textarea><br>
        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>