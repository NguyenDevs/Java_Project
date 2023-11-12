import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/QLHH";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy tổng số nhà cung cấp đã cung cấp mặt hàng có Đơn giá 100
    public static void getTotalSuppliersForPrice(double price) {
        String sql = "SELECT COUNT(DISTINCT CC.MSNCC) AS TotalSuppliers " +
                     "FROM CC " +
                     "JOIN MH ON CC.MSNCC = MH.MSNCC " +
                     "WHERE MH.Dongia = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Tổng số nhà cung cấp đã cung cấp mặt hàng có Đơn giá " + price + ":");
            System.out.printf("%-20s%n", "Tổng Số Nhà Cung Cấp");
            System.out.println("------------------------");

            if (resultSet.next()) {
                int totalSuppliers = resultSet.getInt("TotalSuppliers");
                System.out.printf("%-20d%n", totalSuppliers);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy tổng số nhà cung cấp đã cung cấp mặt hàng có Đơn giá 100
        getTotalSuppliersForPrice(100);
    }
}
