import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QLTHUVIEN";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy danh sách các sách không được mượn
    public static void getAvailableBooks() {
        String sql = "SELECT SACH.* " +
                     "FROM SACH " +
                     "LEFT JOIN CHITIETMUON ON SACH.Masach = CHITIETMUON.Masach " +
                     "WHERE CHITIETMUON.Masach IS NULL OR CHITIETMUON.Tinhtrangtra = 'Chưa trả'";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Danh sách sách không được mượn:");
            System.out.printf("%-10s %-10s %-15s%n", "Masach", "MaLoaiS", "TinhtrangS");
            System.out.println("-----------------------------");

            while (resultSet.next()) {
                String maSach = resultSet.getString("Masach");
                String maLoaiS = resultSet.getString("MaLoaiS");
                String tinhTrangS = resultSet.getString("TinhtrangS");

                System.out.printf("%-10s %-10s %-15s%n", maSach, maLoaiS, tinhTrangS);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách các sách không được mượn
        getAvailableBooks();
    }
}
