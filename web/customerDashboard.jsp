<%@page import="model.SalesInvoice"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Dashboard</title>
        <link rel="stylesheet" href="css/CustomerDash.css">
    </head>
    <body>
        <header>
            <h1>Customer Dashboard</h1>
        </header>
        <div class="container">
            <div class="section">
                <h2>View Invoices</h2>
                <form action="MainServlet" method="get" accept-charset="utf-8">
                    <div class="search-bar">                        
                        <input type="submit" name="action" value="Search_Invoice">
                    </div>
                </form>
                <table class="table" id="invoiceTable">      
                    <thead>
                        <tr>
                            <th>Invoice ID</th>
                            <th>Date</th>
                            <th>Sales ID</th>
                            <th>Car ID</th>
                            <th>Customer ID</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Invoice data will be added here -->
                        <%
                            ArrayList<SalesInvoice> kq = (ArrayList<SalesInvoice>) request.getAttribute("RESULT_INVOICE");
                            if (kq != null && !kq.isEmpty()) {
                                for (SalesInvoice in : kq) {
                        %>                    
                        
                        <tr>
                            <td><%= in.getInvoiceID()%></td>
                            <td><%= in.getCreatedate()%></td>
                            <td><%= in.getSaleID()%></td>
                            <td><%= in.getCarID()%></td>
                            <td><%= in.getCustID()%></td>                           
                        </tr>                                          
                        <%
                            }
                        }
                        %>
                        
                    </tbody>
                </table>
            </div>
            <div class="section">
                <h2>Edit Profile</h2>
                <form action="ProfileServlet" method="post" accept-charset="utf-8">
                    <div class="profile-info">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    <div class="profile-info">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div class="profile-info">
                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" name="phone">
                    </div>
                    <button type="submit">Update Profile</button>
                </form>
            </div>
        </div>
    </body>
</html>
