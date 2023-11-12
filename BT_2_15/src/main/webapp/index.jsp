<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tính điểm trung bình và xếp loại</title>
</head>
<body>

    <h2>Tính điểm trung bình và xếp loại</h2>

    <form method="post" action="ketqua.jsp">
        <label for="lyThuyet">Nhập điểm lý thuyết: </label>
        <input type="text" id="lyThuyet" name="lyThuyet" required>
        <br>
        <label for="thucHanh">Nhập điểm thực hành: </label>
        <input type="text" id="thucHanh" name="thucHanh" required>
        <br>
        <input type="submit" value="Tính điểm">
    </form>

</body>
</html>
