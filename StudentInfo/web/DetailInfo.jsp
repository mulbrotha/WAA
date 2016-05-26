<%-- 
    Document   : DetailInfo.jsp
    Created on : May 25, 2016, 9:27:38 PM
    Author     : mulu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student information</title>
        <style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
    </head>
    <body>
        <div align="center">
            <table style="width:50%">
                <tr>
                    <th>Student ID</th>
                    <th>Firstname</th>
                    <th>GPA</th>
                    <th>Gender</th>
                </tr>  
                <c:forEach items="${Student}" var="student">
    <tr>
       <td>${student.sID}</td>
       <td>${student.sName}</td>
       <td>${student.gpa}</td>
       <td>${student.sGender}</td>
    </tr>
</c:forEach>
            </table>
            <br><br>
            <form action="Home.jsp"> 
                <input type="submit" name="done" value="Done"/>
            </form>
        </div>
    </body>
</html>
