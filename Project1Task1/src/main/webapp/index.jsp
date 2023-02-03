<%--Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: index.jsp
 * Part Of: Project1Task1--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Clicker</title>
    </head>

    <body>
        <form action="compute-hashes" method="get">
            <table>
                <tr>
                    <td>Enter string:</td>
                    <td><input type="text" name="userString"></td>
                </tr>
            </table>

            <h3>Choose hash function:</h3>

            <input type="radio" id="md5" name="hash_function" value="MD5" checked="checked">
            <label for="md5">MD5</label><br>
            <input type="radio" id="sha-256" name="hash_function" value="SHA-256">
            <label for="sha-256">SHA-256</label><br><br>

            <input type="submit" value="Compute Hash">
        </form>
    </body>
</html>