<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tính điểm trung bình và xếp loại</title>
</head>
<body>

    <h2>Kết quả tính điểm trung bình và xếp loại</h2>

    <%-- Mã Java để tính trung bình và xác định phân loại --%>
    <%
        String lyThuyetStr = request.getParameter("lyThuyet");
        String thucHanhStr = request.getParameter("thucHanh");

        if (lyThuyetStr != null && thucHanhStr != null) {
            try {
                double lyThuyet = Double.parseDouble(lyThuyetStr);
                double thucHanh = Double.parseDouble(thucHanhStr);

                double diemTrungBinh = calculateAverage(lyThuyet, thucHanh);
                String xepLoai = classifyStudent(diemTrungBinh);

    %>
                <br>
                Điểm trung bình: <%= diemTrungBinh %><br>
                Xếp loại: <%= xepLoai %>
    <%
            } catch (NumberFormatException e) {
    %>
                <br>
                Vui lòng nhập điểm hợp lệ.
    <%
            }
        }
    %>

    <%-- Mã Java để tính điểm học sinh --%>
    <%!
        double calculateAverage(double lyThuyet, double thucHanh) {
            return (lyThuyet + 2 * thucHanh) / 3;
        }
    %>

    <%-- Mã Java để xếp loại học sinh --%>
    <%!
        String classifyStudent(double diemTrungBinh) {
            if (diemTrungBinh >= 5) {
                return "Đỗ";
            } else {
                return "Trượt";
            }
        }
    %>

    <p><a href="index.jsp">Quay lại</a></p>

</body>
</html>
