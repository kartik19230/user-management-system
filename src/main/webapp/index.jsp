<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>User Registration</h2>

<c:if test="${not empty errors}">
    <c:forEach var="e" items="${errors}">
        <p style="color:red;">${e}</p>
    </c:forEach>
</c:if>

<form action="newForm" method="post">

    Name:<input type="text" name="name" value="${name}" /><br>
    Age:<input type="number" name="age" value="${age}" /><br>
    Email:<input type="email" name="email" value="${email}" /><br>
    Phone:<input type="text" name="phone" value="${phone}" /><br>
    Password:<input type="password" name="password" /><br><br>

    <button type="submit">Submit</button><br>
    
    Already have account?
	<a href="login.jsp">Login Here</a>

</form>

</body>
</html>