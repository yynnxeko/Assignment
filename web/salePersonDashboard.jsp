<%@page import="model.Cars"%>
<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard Ô Tô Nâng Cao</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <header>
            <h1>Dashboard Ô Tô Nâng Cao</h1>
        </header>
        <div class="container">
            <div class="section">
                <h2>Quản Lý Khách Hàng</h2>
                <form action="MainServlet" accept-charset="utf-8">
                    <div class="search-bar">
                        <input type="text" id="customerSearch" name="customerSearch" placeholder="Tìm khách hàng theo tên...">
                        <input type="submit" name="action" value="find">
                    </div>
                </form>
                <table class="table" id="customerTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên Khách Hàng</th>
                            <th>Điện Thoại</th>
                            <th>Giới tính</th>
                            <th>Địa chỉ</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Customer> kq = (ArrayList) request.getAttribute("RESULT");
                            if (kq != null && !kq.isEmpty()) {
                                for (Customer v : kq) {
                        %>
                        <tr>
                            <td><%= v.getCustID()%></td>
                            <td><%= v.getCustName()%></td>
                            <td><%= v.getPhone()%></td>
                            <td><%= v.getSex()%></td>
                            <td><%= v.getCustAddress()%></td>
                            <td class="active">
                                <a class="update" href="editCustomer?id=<%= v.getCustID()%>" title="Sửa">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a class="delete" href="deleteCustomer?id=<%= v.getCustID()%>" title="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">
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
            <div class="section">
                <h2>Quản Lý Xe</h2>
                <form action="MainServlet" accept-charset="utf-8">
                    <div class="search-bar">
                        <input type="text" id="carSearch" name="carSearchSerial" placeholder="Tìm xe theo số serial">
                        <input type="text" id="carSearch" name="carSearchModel" placeholder="Tìm xe theo số mẫu">
                        <input type="text" id="carSearch" name="carSearchYear" placeholder="Tìm xe theo số năm...">
                        <input type="submit" name="action" value="find_car">
                    </div>
                </form>

                <table class="table" id="carTable">
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
                            ArrayList<Cars> car = (ArrayList) request.getAttribute("RESULT_CAR");
                            if (car != null && !car.isEmpty()) {
                                for (Cars v : car) {
                        %>
                        <tr>
                            <td><%= v.getCarID()%></td>
                            <td><%= v.getSerialNumber()%></td>
                            <td><%= v.getModel()%></td>
                            <td><%= v.getColour()%></td>
                            <td><%= v.getYear()%></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <div class="section">
                <h2>Tạo Vé Dịch Vụ</h2>
                <input type="text" id="serviceCustomer" placeholder="Tên Khách Hàng">
                <button>Tạo Vé</button>
            </div>
        </div>
    </body>

</html>