<%-- 
    Document   : updateCar
    Created on : Mar 8, 2025, 12:26:10 AM
    Author     : BAO MINH
--%>

<%@page import="model.Cars"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="section">
            <h2>Quản Lý Khách Hàng</h2>
            <a href="MainServlet?action=dashboard">Trang chủ<a/><br><br>
                <form action="MainServlet" accept-charset="utf-8" method="POST">
                    <%
                        ArrayList<Cars> car = (ArrayList) request.getAttribute("RESULT");
                        if (car != null && !car.isEmpty()) {
                            for (Cars v : car) {
                    %>
                    <input type="hide" name="carID" value="<%= v.getCarID()%>">
                    <label for="serialNumber">Số serial:</label>
                    <input type="text" id="serialNumber" name="serialNumber" value="<%= v.getSerialNumber()%>" required>

                    <label for="Model">Model:</label>
                    <input type="text" id="Model" name="Model" value="<%= v.getModel()%>" required>

                    <label for="Color">Color:</label>
                    <input type="text" id="Color" name="Color" value="<%= v.getColour()%>" required>

                    <label for="Year">Year:</label>
                    <input type="text" id="Year" name="Year" value="<%= v.getYear()%>" required>
                    <input type="submit" name="action" value="update_car">
                    <%
                            }
                        }
                    %>

                </form>
        </div>
    </body>
</html>
