<%-- 
    Document   : Search.jsp
    Created on : May 25, 2016, 9:29:00 PM
    Author     : mulu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <div align="center">
            <div>
                 <form action="/StudentInfo/ServletController" method="GET">
                    Enter Id: <input type="text" name="id"/><br>
                    <input type="submit" name="findbtn"value="Find"/>
                <input type="submit" name="cancelSearch" value="cancel"/>
               </form>
            </div>
            
        </div>
    </body>
</html>
