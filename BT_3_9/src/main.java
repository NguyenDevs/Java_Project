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

    // Phương thức lấy danh sách môn học có số đơn vị học trình là 5 và 6
    public static void getCoursesWithCredits(int credit1, int credit2) {
        String sql = "SELECT * FROM MONHOC WHERE Sodvht IN (?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, credit1);
            preparedStatement.setInt(2, credit2);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Danh sách môn học có số đơn vị học trình là " + credit1 + " và " + credit2 + ":");
            System.out.printf("%-10s %-20s %-10s%n", "MaMH", "TenMH", "Sodvht");
            System.out.println("--------------------------------");

            while (resultSet.next()) {
                String maMH = resultSet.getString("MaMH");
                String tenMH = resultSet.getString("TenMH");
                int soDVHT = resultSet.getInt("Sodvht");

                System.out.printf("%-10s %-20s %-10s%n", maMH, tenMH, soDVHT);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách môn học có số đơn vị học trình là 5 và 6
        getCoursesWithCredits(5, 6);
    }
}
