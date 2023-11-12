import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Chưa hiểu đề lắm (câu b)
public class main {
    // Thông tin kết nối cơ sở dữ liệu MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QLHH";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy tên nhà cung cấp mặt hàng có mã 03 và sắp xếp giảm dần theo đơn giá
    public static void getSupplierNameForProduct(String productCode) {
        String sql = "SELECT CC.TENNCC " +
                     "FROM CC " +
                     "JOIN MH ON CC.MSNCC = MH.MSNCC " +
                     "WHERE MH.MSMH = ? " +
                     "ORDER BY MH.Dongia DESC";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, productCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Nhà cung cấp mặt hàng có mã " + productCode + " và sắp xếp giảm dần theo đơn giá:");
            System.out.printf("%-30s%n", "Tên Nhà Cung Cấp");
            System.out.println("----------------------------");

            while (resultSet.next()) {
                String tenNCC = resultSet.getString("TENNCC");
                System.out.printf("%-30s%n", tenNCC);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy tên nhà cung cấp mặt hàng có mã 03 và sắp xếp giảm dần theo đơn giá
        getSupplierNameForProduct("03");
    }
}
