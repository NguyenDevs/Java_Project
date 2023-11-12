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
    <form class="form" action="formProcessing.jsp" method="post">
       <h1>Widget Order Form</h1>
        <label for="username">Username:</label>
        <input class="input" type="text" name="username" required><br>

        <label for="pass">Password:</label>
        <input class="input"type="password" name="pass" required><br>

        <label for="firstname">First Name:</label>
        <input class="input"type="text" name="firstname" required><br>

        <label for="lastname">Last Name:</label>
        <input class="input"type="text" name="lastname" required><br>

        <label for="gender">Gender:</label>
        <input class="radio"type="radio" name="gender" value="male" checked> Male
        <input class="radio"type="radio" name="gender" value="female"> Female<br>

        <label for="address">Address:</label>
        <textarea class="input"name="address" rows="1" cols="30" required></textarea><br>

        <input class="submit" type="submit" value="Place Order">
    </form>
</body>
</html>