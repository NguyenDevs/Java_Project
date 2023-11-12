<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả liệt kê số nguyên tố</title>
</head>
<body>

    <h2>Kết quả liệt kê số nguyên tố</h2>

    <%-- Mã Java để liệt kê danh sách số nguyên tố --%>
    <%
        String numberStr = request.getParameter("number");

        if (numberStr != null) {
            try {
                int n = Integer.parseInt(numberStr);

                if (n > 1) {
    %>
                    <p>Các số nguyên tố nhỏ hơn hoặc bằng <%= n %> là:</p>
                    <ul>
    <%
                    for (int i = 2; i <= n; i++) {
                        if (checkPrime(i)) {
    %>
                            <li><%= i %></li>
    <%
                        }
                    }
    %>
                    </ul>
    <%
                } else {
    %>
                    <p>Vui lòng nhập số nguyên lớn hơn 1.</p>
    <%
                }
            } catch (NumberFormatException e) {
    %>
                <p>Vui lòng nhập số nguyên hợp lệ.</p>
    <%
            }
        }
    %>

    <%-- Mã java để kiểm tra một số có phải là số nguyên tố hay không --%>
    <%!
        boolean checkPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    %>

    <p><a href="index.jsp">Quay lại</a></p>

</body>
</html>
