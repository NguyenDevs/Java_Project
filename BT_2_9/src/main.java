import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/QLKS";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Nhập thông tin từ người dùng
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập loại phòng: ");
            String loaiPhong = scanner.nextLine();
            System.out.print("Nhập đơn giá: ");
            double donGia = scanner.nextDouble();

            // Thêm bản ghi mới vào bảng LOAIPHONG
            addNewRecordToLoaiPhong(connection, loaiPhong, donGia);

            // Đóng kết nối
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewRecordToLoaiPhong(Connection connection, String loaiPhong, double donGia) throws SQLException {
        String query = "INSERT INTO LOAIPHONG (Loaiphong, Dongia) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loaiPhong);
            preparedStatement.setDouble(2, donGia);
            preparedStatement.executeUpdate();
            System.out.println("Bản ghi đã được thêm vào bảng LOAIPHONG.");
        }
    }
}
