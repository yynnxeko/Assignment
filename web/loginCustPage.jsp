<%-- 
    Document   : loginCustPage
    Created on : Mar 1, 2025, 5:34:11 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login to Garage System</h1>
        <form action="MainServlet" accept-charset="utf-8">  
            <input type="text" id="txtname" name="txtname" required><br><br>
            <input type="text" id="txtphone" name="txtphone">
            <input type="submit" name="action" value="CustomerLogin">
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
