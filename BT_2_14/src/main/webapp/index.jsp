<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm nghiệm phương trình</title>
</head>
<body>

    <h2>Tìm nghiệm phương trình ax + b = 0</h2>

    <form method="post" action="ketqua.jsp">
        <label for="a">Nhập số nguyên a: </label>
        <input type="text" id="a" name="a" required>
        <br>
        <label for="b">Nhập số nguyên b: </label>
        <input type="text" id="b" name="b" required>
        <br>
        <input type="submit" value="Tìm nghiệm">
    </form>

</body>
</html>
