<%--Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: result.jsp
 * Part Of: Project1Task1--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Clicker</title>
  </head>
  <body>
    <h2>Original Text: <%= request.getAttribute("user_input")%></h2>
    <h2>Hash Function: <%= request.getAttribute("hash_function")%></h2>
    <h2>Hexadecimal Hash Value: <%= request.getAttribute("hex_hash")%></h2>
    <h2>Base 64 Hash Value: <%= request.getAttribute("b64_hash")%></h2>
  </body>
</html>