<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nguyễn Tài Nguyên</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
 <%
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
    %>
    <div class="form2">
    <h1>Order Confirmation</h1>
    <p>Thanks you for you order of
    <br>Username: <%= username %>
    <br>pass: <%= pass %>
    <br>Firstname: <%= firstname %>
    <br>Lastname: <%= lastname %>
    <br>Address: <%= address %>
    <br>Gender: <%= gender %></p>
</div>
</body>
</html>
