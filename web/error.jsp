<%-- 
    Document   : error
    Created on : Feb 19, 2025, 3:18:46 PM
    Author     : BAO MINH
--%>

<%@page import="model.SalesPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
             HttpSession s = request.getSession();
             SalesPerson sale = (SalesPerson) s.getAttribute("user");
             out.println(sale);
        %>
    </body>
</html>
