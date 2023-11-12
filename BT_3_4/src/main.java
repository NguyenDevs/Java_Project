import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QLHH";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy các mặt hàng được cung cấp bởi nhà cung cấp có địa chỉ 'Nghệ An'
    public static void getProductsBySupplierAddress(String supplierAddress) {
        String sql = "SELECT MH.* " +
                     "FROM CC " +
                     "JOIN MH ON CC.MSNCC = MH.MSNCC " +
                     "WHERE CC.DCNCC = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, supplierAddress);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Các mặt hàng được cung cấp bởi nhà cung cấp có địa chỉ '" + supplierAddress + "':");
            System.out.printf("%-10s %-10s %-10s %-10s%n", "MSMH", "SoLuong", "Dongia", "MSNCC");
            System.out.println("----------------------------------");

            while (resultSet.next()) {
                String msMH = resultSet.getString("MSMH");
                int soLuong = resultSet.getInt("SoLuong");
                double dongia = resultSet.getDouble("Dongia");
                String msNCC = resultSet.getString("MSNCC");

                System.out.printf("%-10s %-10s %-10s %-10s%n", msMH, soLuong, dongia, msNCC);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy các mặt hàng được cung cấp bởi nhà cung cấp có địa chỉ 'Nghệ An'
        getProductsBySupplierAddress("Nghệ An");
    }
}
