<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tính Ước chung lớn nhất</title>
</head>
<body>

    <h2>Tính Ước chung lớn nhất</h2>

    <form method="post" action="index.jsp">
        <label for="number1">Nhập số a: </label>
        <input type="text" id="number1" name="number1" required>
        <br>
        <label for="number2">Nhập số b: </label>
        <input type="text" id="number2" name="number2" required>
        <br>
        <input type="submit" value="Tính Ước chung lớn nhất">
    </form>

    <%-- Mã Java để tìm Ước chung lớn nhất --%>
    <%
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");

        if (number1Str != null && number2Str != null) {
            try {
                int number1 = Integer.parseInt(number1Str);
                int number2 = Integer.parseInt(number2Str);

                int result = findGCD(number1, number2);

    %>
                <br>
                Ước chung lớn nhất của <%= number1 %> và <%= number2 %> là <%= result %>.
    <%
            } catch (NumberFormatException e) {
    %>
                <br>
                Vui lòng nhập số hợp lệ.
    <%
            }
        }
    %>

    <%-- Hàm Java tìm ước chung lớn nhất --%>
    <%!
        int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    %>

</body>
</html>
