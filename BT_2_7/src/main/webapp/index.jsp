

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nguyễn Tài Nguyên</title>
<link rel="stylesheet" href="style.css">
<script src="script.js"></script>
<link rel="icon" type="image/x-icon" href="vuted.png">

</head>
<body>
<form class="form" action="check.jsp" method="post">
    <h1 class="header">Order Form</h1>
        <label class="texter">
        Number to purchase:
        <input type="text" class="info" name="number" >
    </label>
    <br>
    <label class="texter"> Your Name:
        <input type="text" class="info" name="name">
    </label>
    <br>
    <label class="texter"> Your email:
        <input type="text" class="info" name="email">
    </label>
    <br>
    <input type="submit" class="submit" value="Place Order">
<br>
</form>
</body>
</html>