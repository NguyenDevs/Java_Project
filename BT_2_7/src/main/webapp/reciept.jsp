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
 double pricePerUnit = 9.95;
 double quantityNumber = 0;
 double totalCost = 0.0;
 if(number != null && !number.isEmpty()){
   try{
	quantityNumber = Integer.parseInt(number);
	totalCost = pricePerUnit * quantityNumber;
 } catch (NumberFormatException e){
	 out.println("Số lượng không hợp lệ");
     }
 }
 %>
 <form class="form">
 <h1 class="header">Order Confirmation</h1>
 <label class="atw"> Thank you for your order of <%=quantityNumber%> widgets, <%=name%>.</label><br>
 <label class="atw"> At $<%=pricePerUnit%>, your bill will be $<%=totalCost%>.</label><br>
 <label class="atw"> You will shortly receive an email confirmation at <%=email%>.</label><br>
 </form>
</body>
</html>