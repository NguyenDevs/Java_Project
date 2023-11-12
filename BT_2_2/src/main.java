/*
 Cho cơ sở dữ liệu MySQL QLSV(Quản lý sinh viên) có bảng tbl_Khoa (id, MaKhoa, 
TenKhoa). Thực hiện các yêu cầu sau:
a. Viết phương thức DB_Connection() để kết nối cơ sở dữ liệu đó
b. Viết một phương thức hiển thị danh sách các bản ghi trong bảng tbl_Khoa lên 
hộp thoại hoặc màn hình Console.

 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

    // Thay đổi thông tin kết nối tới cơ sở dữ liệu của bạn
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối đến cơ sở dữ liệu
    public static Connection DB_Connection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return connection;
    }

    // Phương thức hiển thị danh sách các bản ghi trong bảng tbl_Khoa
    public static void displayKhoaRecords() {
        try (Connection connection = DB_Connection()) {
            String sql = "SELECT id, MaKhoa, TenKhoa FROM tbl_Khoa";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("ID\tMaKhoa\tTenKhoa");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String maKhoa = resultSet.getString("MaKhoa");
                    String tenKhoa = resultSet.getString("TenKhoa");
                    System.out.println(id + "\t" + maKhoa + "\t" + tenKhoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức hiển thị danh sách các bản ghi
        displayKhoaRecords();
    }
}
