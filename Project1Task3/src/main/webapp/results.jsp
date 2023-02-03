<%--Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: results.jsp
 * Part Of: Project1Task3--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%= request.getAttribute("doctype") %>

<html>
  <head>
    <title>Clicker</title>
  </head>
  <body>
    <p><%= request.getAttribute("results")%></p>
  </body>
</html>