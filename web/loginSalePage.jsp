<%-- 
    Document   : index
    Created on : Feb 19, 2025, 2:59:00 PM
    Author     : BAO MINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login to Garage System</h1>
        <form action="MainServlet" accept-charset="utf-8">  
            <input type="text" id="username" name="username" required><br><br>
            <input type="submit" name="action" value="Login">
        </form>
        <p>
            <%
                if (request.getAttribute("ERROR") != null) {
                    out.println(request.getAttribute("ERROR"));
                }
            %>
        </p>
    </body>
</html>
