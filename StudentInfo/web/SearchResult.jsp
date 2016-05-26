<%-- 
    Document   : SearchResult.jsp
    Created on : May 25, 2016, 9:36:03 PM
    Author     : mulu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        <div align="center">
            <div>
                <h1> Searched Student Details.</h1>
                ID:  ${std.sID}<BR/>
                NAME:   ${std.sName}<BR/>
                GPA:  ${std.gpa}<BR/>
                GENDER:  ${std.sGender}<BR/>
            </div>
            <div>
                 <form action="/StudentInfo/ServletController" method="GET">
             <input type="submit"  name="deleteStudent" value="Delete" /><BR/>
             <input type="submit" name ="canceldelete" value="cancel" /><BR/>
        </form>
            </div>
            
        </div>
    </body>
</html>
