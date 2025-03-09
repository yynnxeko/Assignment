<%-- 
    Document   : updateCustomer
    Created on : Mar 5, 2025, 3:27:46 PM
    Author     : BAO MINH
--%>

<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cập Nhật Khách Hàng</title>
        <link rel="stylesheet" href="css/updateCust.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <div class="section">
            <h2>Cập Nhật Thông Tin Khách Hàng</h2>
            <form action="MainServlet" accept-charset="utf-8" method="POST">
                <%
                    ArrayList<Customer> kq = (ArrayList) request.getAttribute("RESULT");
                    if (kq != null && !kq.isEmpty()) {
                        for (Customer v : kq) {
                %>
                <input type="hide" name="custID" value="<%= v.getCustID()%>">
                <label for="custName">Tên Khách Hàng:</label>
                <input type="text" id="custName" name="custName" value="<%= v.getCustName()%>" required>

                <label for="phone">Điện Thoại:</label>
                <input type="text" id="phone" name="phone" value="<%= v.getPhone()%>" required>

                <label for="sex">Giới Tính:</label>
                <select id="sex" name="sex" required>
                    <option value="M" <%= v.getSex().equals("M") ? "selected" : ""%>>Nam</option>
                    <option value="F" <%= v.getSex().equals("F") ? "selected" : ""%>>Nữ</option>
                </select>

                <label for="custAddress">Địa Chỉ:</label>
                <input type="text" id="custAddress" name="custAddress" value="<%= v.getCustAddress()%>" required>
                <input type="submit" name="action" value="update">
                <%
                        }
                    }
                %>

            </form>
        </div>
    </body>
</html>

