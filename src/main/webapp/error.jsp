<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color:red">Errors:</h2>

<% 
    java.util.List<String> errors = (java.util.List<String>) request.getAttribute("errors");
    if(errors != null){
        for(String e : errors){
%>
            <p style="color:red"><%= e %></p>
<%
        }
    }
%>

</body>
</html>
