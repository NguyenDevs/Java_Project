import java.sql.*;

public class main {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/QLKS";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Hiển thị danh sách phòng
            displayRoomList(connection);

            // Đóng kết nối
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayRoomList(Connection connection) throws SQLException {
        String query = "SELECT PHONG.Sohieuphong, LOAIPHONG.Loaiphong, PHONG.Tang, PHONG.Thietbi, LOAIPHONG.Dongia " +
                       "FROM PHONG INNER JOIN LOAIPHONG ON PHONG.loaiphong = loaiphong.Loaiphong";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Danh sách phòng:");
            System.out.println("Số hiệu | Loại phòng | Tầng | Thiết bị | Đơn giá");
            while (resultSet.next()) {
                String soHieuPhong = resultSet.getString("Sohieuphong");
                String loaiPhong = resultSet.getString("Loaiphong");
                int tang = resultSet.getInt("Tang");
                String thietBi = resultSet.getString("Thietbi");
                double donGia = resultSet.getDouble("Dongia");

                System.out.printf("%s | %s | %d | %s | %.2f\n", soHieuPhong, loaiPhong, tang, thietBi, donGia);
            }
        }
    }
}

