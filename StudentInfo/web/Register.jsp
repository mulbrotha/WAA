<%-- 
    Document   : Home
    Created on : May 25, 2016, 5:05:52 PM
    Author     : mulu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
        <div>
             <form action="/StudentInfo/ServletController" method="POST">
                ID:
                <input type="text" name="id" /><br><br>
                Name:
                <input type="text" name="name" /><br><br>
                GPA:
                <input type="text" name="gpa"/><br><br>
                Gender:
                <input type="radio" name="gender" value="male" checked> Male
                    <input type="radio" name="gender" value="female"> Female
                    <input type="radio" name="gender" value="other"> Other<br><br>
                    <input type="reset" value="Reset"/>
                <input type="submit" name="addUser" value="Add"/>
                <input type="submit" name="cancel" value="Cancel"/>
            </form>
            
        </div>
        </div>
    </body>
</html>
