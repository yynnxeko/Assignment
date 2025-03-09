<%-- 
    Document   : listCustomer
    Created on : Mar 2, 2025, 6:44:54 PM
    Author     : BAO MINH
--%>

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
                            <th>ID</th>
                            <th>Số Serial</th>
                            <th>Mẫu</th>
                            <th>Màu Sắc</th>
                            <th>Năm</th>
                        </tr>
                    </thead>
                    <tbody>
                         <%
                            ArrayList<Cars> car = (ArrayList) request.getAttribute("RESULT");
                            if (car != null && !car.isEmpty()) {
                                for (Cars v : car) {
                        %>
                        <tr>
                            <tr>
                            <td><%= v.getCarID()%></td>
                            <td><%= v.getSerialNumber()%></td>
                            <td><%= v.getModel()%></td>
                            <td><%= v.getColour()%></td>
                            <td><%= v.getYear()%></td>
                            <td class="active">
                                <a class="update" href="UpdateCarServlet?id=<%= v.getCarID()%>" title="Sửa">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a class="delete" href="DeleteCarServlet?id=<%= v.getCarID()%>" title="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
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
