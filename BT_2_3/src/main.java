/*
 Cho cơ sở dữ liệu MySQL QLSV(Quản lý sinh viên) có bảng tbl_Khoa (id, MaKhoa, 
TenKhoa). Thực hiện các yêu cầu sau:
a. Viết phương thức DB_Connection() để kết nối cơ sở dữ liệu đó. 
b. Viết một phương thức cập nhật một bản ghi vào bảng tbl_Khoa.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    // Phương thức cập nhật một bản ghi trong bảng tbl_Khoa
    public static void updateKhoaRecord(int id, String newMaKhoa, String newTenKhoa) {
        try (Connection connection = DB_Connection()) {
            String sql = "UPDATE tbl_Khoa SET MaKhoa=?, TenKhoa=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newMaKhoa);
                preparedStatement.setString(2, newTenKhoa);
                preparedStatement.setInt(3, id);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Bản ghi đã được cập nhật thành công.");
                } else {
                    System.out.println("Không tìm thấy bản ghi để cập nhật.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức cập nhật một bản ghi
        updateKhoaRecord(1, "040704", "Khoa Tài Nguyên Học");
    }
}
