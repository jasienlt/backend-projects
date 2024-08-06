<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <title>Product Detail</title>
</head>
<body>
	<%@include file='header.jsp'%>
    <h1>Product Detail</h1>
    <c:if test="${not empty product}">
        <p>ID: ${product.id}</p>
        <p>Name: ${product.name}</p>
        <p>Description: ${product.description}</p>
        <p>Price: ${product.price}</p>
        <a href="productSummary.jsp">Back to Product Summary</a>

        <h2>Feedback</h2>
        <c:forEach var="feedback" items="${feedbackList}">
            <p>${feedback.comment}</p>
        </c:forEach>

        <h3>Leave Feedback</h3>
        <form action="product" method="post">
            <input type="hidden" name="action" value="submitFeedback">
            <input type="hidden" name="productId" value="${product.id}">
            <textarea name="comment" rows="4" cols="50"></textarea><br>
            <input type="submit" value="Submit Feedback">
        </form>
    </c:if>
    <c:if test="${empty product}">
        <p>Product not found.</p>
        <a href="productSummary.jsp">Back to Product Summary</a>
    </c:if>
</body>
</html>