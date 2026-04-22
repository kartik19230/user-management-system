<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success page</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>

<h2>Registration Successful</h2>

<p>Name: ${user.name}</p>
<p>Age: ${user.age}</p>
<p>Email: ${user.email}</p>
<p>Phone: ${user.phone}</p>

</body>
</html>