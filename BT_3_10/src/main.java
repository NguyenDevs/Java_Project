import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    // Thông tin kết nối cơ sở dữ liệu
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/QUANLIDIEM";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    // Phương thức lấy tổng số sinh viên của khoa Tin học
    public static void getTotalStudentsInComputerScience() {
        String sql = "SELECT COUNT(*) AS TongSV FROM SINHVIEN " +
                     "JOIN LOP ON SINHVIEN.Tenlop = LOP.Tenlop " +
                     "WHERE LOP.Tenkhoa = 'Tin học'";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int tongSV = resultSet.getInt("TongSV");

                System.out.println("Tổng số sinh viên của khoa Tin học: " + tongSV);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy tổng số sinh viên của khoa Tin học
        getTotalStudentsInComputerScience();
    }
}

