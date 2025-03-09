<%@page import="model.Customer"%>
<%@page import="model.SalesInvoice"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Dashboard</title>
        <link rel="stylesheet" href="css/CustomerDash.css"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
                            ArrayList<SalesInvoice> invoiceList = (ArrayList<SalesInvoice>) request.getAttribute("RESULT_INVOICE");
                            if (invoiceList != null && !invoiceList.isEmpty()) {
                                for (SalesInvoice invoice : invoiceList) {
                        %>                    

                        <tr>
                            <td><%= invoice.getInvoiceID()%></td>
                            <td><%= invoice.getCreatedate()%></td>
                            <td><%= invoice.getSaleID()%></td>
                            <td><%= invoice.getCarID()%></td>
                            <td><%= invoice.getCustID()%></td>                           
                        </tr>                                          
                        <%
                                }
                            }
                        %>

                    </tbody>
                </table>
            </div>
            <div class="section">
                <h2>Edit Profile For Customer</h2>
                <form action="MainServlet" method="get" accept-charset="utf-8">
                    <div class="search-bar">                        
                        <input type="submit" name="action" value="Find_Customer">
                    </div>
                </form>
                <form>
                    <table class="table" id="customerTable">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Sex</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Customer> customerList = (ArrayList<Customer>) request.getAttribute("RESULT_CUSTOMER");
                                if (customerList != null && !customerList.isEmpty()) {
                                    for (Customer customer : customerList) {
                            %>
                            <tr>
                                <td><input type="text" id="custname" name="custname" value="<%= customer.getCustName()%>" required></td>
                                <td><input type="text" id="custphone" name="custphone" value="<%= customer.getPhone()%>" required></td>
                                <td><select id="sex" name="custsex" required>
                                        <option value="M" <%= customer.getSex().equals("M") ? "selected" : ""%>>Men</option>
                                        <option value="F" <%= customer.getSex().equals("F") ? "selected" : ""%>>Woman</option>
                                    </select></td>
                                <td><input type="text" id="custAddress" name="custAddress" value="<%= customer.getCustAddress()%>" required></td>
                                <td class="active">
                                    <input type="submit" name="action" value="Update_Customer">                                                  
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>                              
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>