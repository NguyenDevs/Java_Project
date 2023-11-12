<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm nghiệm phương trình</title>
</head>
<body>

    <h2>Kết quả tìm nghiệm phương trình</h2>

    <%-- Mã Java để giải phương trình --%>
    <%
        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");

        if (aStr != null && bStr != null) {
            try {
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);

                double x = solveEquation(a, b);

    %>
                <br>
                Nghiệm của phương trình <%= a %>x + <%= b %> = 0 là x = <%= x %>.
    <%
            } catch (NumberFormatException e) {
    %>
                <br>
                Vui lòng nhập số nguyên hợp lệ.
    <%
            }
        }
    %>

    <%-- Mã Java để giải phương trình ax + b = 0 --%>
    <%!
        double solveEquation(int a, int b) {
            if (a == 0) {
                return Double.POSITIVE_INFINITY; // Phương trình vô nghiệm khi a = 0.
            } else {
                return (double) -b / a;
            }
        }
    %>

    <p><a href="index.jsp">Quay lại</a></p>

</body>
</html>
