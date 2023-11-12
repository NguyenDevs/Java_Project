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
 <%
 String name = request.getParameter("name");
 String email = request.getParameter("email");
 String number = request.getParameter("number");

 if (name == null || name.isEmpty() || email == null || email.isEmpty() || number == null || number.isEmpty()) {
     // Nếu có lỗi, chuyển đến trang hiển thị lỗi
     response.sendRedirect("error.jsp");
 } else {
     // Nếu thông tin đầy đủ, chuyển đến trang hiển thị thông tin
     response.sendRedirect("reciept.jsp?name=" + name + "&email=" + email + "&number=" + number);
 }
 %>
</body>
</html>