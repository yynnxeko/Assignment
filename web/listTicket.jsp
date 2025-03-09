<%-- 
    Document   : listCustomer
    Created on : Mar 2, 2025, 6:44:54 PM
    Author     : BAO MINH
--%>

<%@page import="model.Ticket"%>
<%@page import="model.Cars"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard Ô Tô Nâng Cao</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <div class="section">
                <h2>Quản Lý Khách Hàng</h2>
                <a href="MainServlet?action=dashboard">Trang chủ<a/>
                <table class="table" id="customerTable">
                    <thead>
                        <tr>
                            <th>ServiceTicketID</th>
                            <th>DateReceived</th>
                            <th>DateReturned</th>
                            <th>CustID</th>
                            <th>CarID</th>
                        </tr>
                    </thead>
                    <tbody>
                         <%
                            ArrayList<Ticket> ticket = (ArrayList) request.getAttribute("RESULT");
                            if (ticket != null && !ticket.isEmpty()) {
                                for (Ticket v : ticket) {
                        %>
                        <tr>
                            <tr>
                            <td><%= v.getServiceTicketID()%></td>
                            <td><%= v.getDateReceived()%></td>
                            <td><%= v.getDateReturned()%></td>
                            <td><%= v.getCustID()%></td>
                            <td><%= v.getCarID()%></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="6" style="text-align: center;">Không có kết quả nào.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table><br>
            </div>
    </body>
</html>
