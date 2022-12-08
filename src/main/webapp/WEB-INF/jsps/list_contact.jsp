<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>allContacts</title>
</head>
<body>
      <h2>Contact | List</h2>
      <hr>
      <table border="1">
            <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Source</th>
            </tr>
              <c:forEach  var = "lead" items="${contacts}">
               <tr>
               <td><a href="contactInfo?id=${lead.id}">${lead.firstName}</a></td>
               <td>${lead.lastName}</td>
               <td>${lead.email}</td>
               <td>${lead.mobile}</td>
               <td>${lead.source}</td>
               </tr>
              </c:forEach>   
      </table>
</body>
</html>