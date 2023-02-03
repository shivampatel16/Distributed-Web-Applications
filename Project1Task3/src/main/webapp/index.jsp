<%--Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: index.jsp
 * Part Of: Project1Task3--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String ua = request.getHeader("user-agent"); %>
<% if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) { %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN\" "http://www.w3.org/TR/html4/loose.dtd">
<% } else { %>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.2//EN" "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<% } %>

<html>
<head>
  <title>Clicker</title>
</head>
<body>
<form action="getInitialClicker" method="post">
  <h1>Distributed Systems Class Clicker</h1>
  <h3>Submit your answer to the current question:</h3>
  <input type="radio" id="a" name="answer" value="A">
  <label for="a">A</label><br>
  <input type="radio" id="b" name="answer" value="B">
  <label for="b">B</label><br>
  <input type="radio" id="c" name="answer" value="C">
  <label for="c">C</label><br>
  <input type="radio" id="d" name="answer" value="D">
  <label for="d">D</label><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>