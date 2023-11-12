<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả kiểm tra số nguyên tố</title>
</head>
<body>

    <h2>Kết quả kiểm tra số nguyên tố</h2>

        <%-- Mã Java để kiểm tra một số có phải là số nguyên tố hay không --%>
    <%
        String numberStr = request.getParameter("number");

        if (numberStr != null) {
            try {
                int number = Integer.parseInt(numberStr);

                boolean isPrime = checkPrime(number);

    %>
                <br>
                <%= number %> <%= isPrime ? "là số nguyên tố." : "không phải là số nguyên tố." %>
    <%
            } catch (NumberFormatException e) {
    %>
                <br>
                Vui lòng nhập số nguyên hợp lệ.
    <%
            }
        }
    %>

    <%-- Hàm Java để kiểm tra một số có phải là số nguyên tố hay không --%>
    <%!
        boolean checkPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    %>

    <p><a href="index.jsp">Quay lại</a></p>

</body>
</html>
