<%-- 
    Document   : Home.jsp
    Created on : May 25, 2016, 10:40:23 PM
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
        <div> <form action="Register.jsp" method="GET">
                <input type="submit" value="ADD student" /><br><br>
            </form>
        </div>
        <div> <form action="DetailInfo.jsp" method="GET">
               <input type="submit" value="View student" /><br><br>
            </form>
        </div>
        <div> <form action="Search.jsp" method="GET">
               <input type="submit" value="Delete student" /><br><br>
            </form>
        </div>
            </div>
    </body>
</html>
