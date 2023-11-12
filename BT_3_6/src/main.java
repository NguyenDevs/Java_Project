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

    // Phương thức lấy danh sách sinh viên học ngành Công nghệ thông tin
    public static void getStudentsInIT() {
        String sql = "SELECT SINHVIEN.* " +
                     "FROM SINHVIEN " +
                     "JOIN LOP ON SINHVIEN.Malop = LOP.Malop " +
                     "WHERE LOP.Nganh = 'Công nghệ thông tin'";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Danh sách sinh viên học ngành Công nghệ thông tin:");
            System.out.printf("%-10s %-20s %-10s %-10s %-10s%n", "MaSV", "TenSV", "Ngaysinh", "Gioitinh", "Malop");
            System.out.println("-------------------------------------------------");

            while (resultSet.next()) {
                String maSV = resultSet.getString("MaSV");
                String tenSV = resultSet.getString("TenSV");
                String ngaySinh = resultSet.getString("Ngaysinh");
                String gioiTinh = resultSet.getString("Gioitinh");
                String maLop = resultSet.getString("Malop");

                System.out.printf("%-10s %-20s %-10s %-10s %-10s%n", maSV, tenSV, ngaySinh, gioiTinh, maLop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách sinh viên học ngành Công nghệ thông tin
        getStudentsInIT();
    }
}
