<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
  <title>Employees List</title>
</head>
<body>
<h1>List of Employees</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Department</th>
    <th>Position</th>
  </tr>
  <c:if test="${not empty employees}">
    <p>Total Employees: ${fn:length(employees)}</p>
  </c:if>
  <c:if test="${empty employees}">
    <tr>
      <td colspan="6">No employees found.</td>
    </tr>
  </c:if>

  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      <td>${employee.phone}</td>
      <td>${employee.department}</td>
      <td>${employee.position}</td>
    </tr>
  </c:forEach>

  <c:if test="${not empty employees}">
    <p>Total Employees: ${fn:length(employees)}</p>
  </c:if>

</table>
</body>
</html>
