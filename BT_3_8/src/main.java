import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QLTHUVIEN";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy danh sách độc giả có địa chỉ Nghệ An, Thanh Hoá và Hà Tĩnh
    public static void getReadersInProvinces() {
        String sql = "SELECT * FROM DOCGIA WHERE Diachi IN ('Nghệ An', 'Thanh Hoá', 'Hà Tĩnh')";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Danh sách độc giả có địa chỉ Nghệ An, Thanh Hoá và Hà Tĩnh:");
            System.out.printf("%-10s %-20s %-10s %-10s %-20s %-20s%n", "MaDG", "TenDG", "Ngaysinh", "Gioitinh", "Diachi", "Ngaylamthe");
            System.out.println("---------------------------------------------------------------");

            while (resultSet.next()) {
                String maDG = resultSet.getString("MaDG");
                String tenDG = resultSet.getString("TenDG");
                String ngaySinh = resultSet.getString("Ngaysinh");
                String gioiTinh = resultSet.getString("Gioitinh");
                String diaChi = resultSet.getString("Diachi");
                String ngayLamThe = resultSet.getString("Ngaylamthe");

                System.out.printf("%-10s %-20s %-10s %-10s %-20s %-20s%n", maDG, tenDG, ngaySinh, gioiTinh, diaChi, ngayLamThe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách độc giả có địa chỉ Nghệ An, Thanh Hoá và Hà Tĩnh
        getReadersInProvinces();
    }
}
