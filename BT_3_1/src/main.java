import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QLKS";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy danh sách khách có địa chỉ là 'Hà Nội' và sắp xếp theo địa chỉ
    public static void getCustomersInHanoi() {
        String sql = "SELECT * FROM KHACH WHERE Diachi LIKE 'Hà Nội%' ORDER BY Diachi ASC";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Danh sách khách hàng ở Hà Nội:");
            System.out.printf("%-10s %-20s %-30s %-20s %-15s%n", "Makhach", "Tenkhach", "Diachi", "Taikhoan", "SoCMND");
            System.out.println("--------------------------------------------------------------------------------------");

            while (resultSet.next()) {
                String maKhach = resultSet.getString("Makhach");
                String tenKhach = resultSet.getString("Tenkhach");
                String diaChi = resultSet.getString("Diachi");
                String taiKhoan = resultSet.getString("Taikhoan");
                String soCMND = resultSet.getString("SoCMND");

                System.out.printf("%-10s %-20s %-30s %-20s %-15s%n", maKhach, tenKhach, diaChi, taiKhoan, soCMND);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách khách ở Hà Nội
        getCustomersInHanoi();
    }
}
