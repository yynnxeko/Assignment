<%-- 
    Document   : loginCustPage
    Created on : Mar 1, 2025, 5:34:11 PM
    Author     : ASUS
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login to Garage System</h1>
        <form action="MainServlet" accept-charset="utf-8"> 

            <p><input type="text" name="txtname" required=""/>*</p>
            <p><input type="text" name="txtphone" required=""/>*</p>
            <p><input type="submit" name="action" value="CustomerLogin"/></p>

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
