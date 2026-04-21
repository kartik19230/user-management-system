<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.project.model.User" %>
	<% 
	User user = (User) session.getAttribute("user");
	%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <div class="dashboard">
            <h2>Welcome <%= user.getName() %></h2>
            
            <p>Email: <%= user.getEmail() %></p>
            <p>Age: <%= user.getAge() %></p>
            <p>Phone: <%= user.getPhone() %></p>
            
            <a href="logout" class="logout-btn">Logout</a>
        </div>
    </div>
</body>
</html>