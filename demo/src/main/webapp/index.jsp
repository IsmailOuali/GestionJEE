<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="addEmployee" method="post">
    Name: <input type="text" name="name"><br>
    Email: <input type="email" name="email"><br>
    Phone: <input type="text" name="phone"><br>
    Department: <input type="text" name="department"><br>
    Position: <input type="text" name="poste"><br>
    <input type="submit" value="Add Employee">
</form>


</body>
</html>