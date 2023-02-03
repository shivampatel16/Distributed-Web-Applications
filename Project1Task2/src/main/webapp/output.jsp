<%--Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: output.jsp
 * Part Of: Project1Task2--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Clicker</title>
  </head>
  <body>
    <h1>State: <%= request.getAttribute("state")%></h1>
    <h2>Population: <%= request.getAttribute("population")%></h2>
    <h2>Nickname: <%= request.getAttribute("nickname")%></h2>
    <h2>Capital: <%= request.getAttribute("capital")%></h2>
    <h2>Song: <%= request.getAttribute("song")%></h2>
    <h2>Flower: <%= request.getAttribute("flower_name")%></h2>
    <img src="<%= request.getAttribute("flower_image")%>">
    <h3>Credit: https://statesymbolsusa.org/categories/flower</h3>
    <h2>Flag: </h2>
    <img src="<%= request.getAttribute("flag")%>" width="200" height="150">
    <h3>Credit: https://www.states101.com/flags</h3>
    <button onclick="history.back()">Continue</button>
  </body>
</html>