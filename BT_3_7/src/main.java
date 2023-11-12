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

    // Phương thức lấy danh sách sinh viên có điểm dưới 5
    public static void getStudentsWithLowMarks() {
        String sql = "SELECT SINHVIEN.*, MONHOC.TenMon, DIEM.Diem " +
                     "FROM SINHVIEN " +
                     "JOIN DIEM ON SINHVIEN.MaSV = DIEM.MaSV " +
                     "JOIN MONHOC ON DIEM.MaMon = MONHOC.MaMon " +
                     "WHERE DIEM.Diem < 5";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Danh sách sinh viên có điểm dưới 5:");
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-20s %-10s%n", "MaSV", "TenSV", "Ngaysinh", "Gioitinh", "Malop", "TenMon", "Diem");
            System.out.println("------------------------------------------------------------------");

            while (resultSet.next()) {
                String maSV = resultSet.getString("MaSV");
                String tenSV = resultSet.getString("TenSV");
                String ngaySinh = resultSet.getString("Ngaysinh");
                String gioiTinh = resultSet.getString("Gioitinh");
                String maLop = resultSet.getString("Malop");
                String tenMon = resultSet.getString("TenMon");
                double diem = resultSet.getDouble("Diem");

                System.out.printf("%-10s %-20s %-10s %-10s %-10s %-20s %-10s%n", maSV, tenSV, ngaySinh, gioiTinh, maLop, tenMon, diem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức để lấy danh sách sinh viên có điểm dưới 5
        getStudentsWithLowMarks();
    }
}
