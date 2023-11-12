/*
 Cho cơ sở dữ liệu MySQL QLSV(Quản lý sinh viên) có bảng tbl_Khoa (id, MaKhoa, 
TenKhoa). Thực hiện các yêu cầu sau:
a. Viết phương thức DB_Connection() để kết nối cơ sở dữ liệu đó. 
b. Viết một phương thức để xóa một bản ghi có mã khoa (MaKhoa) được nhập từ 
bàn phím.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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

    // Phương thức xóa một bản ghi trong bảng tbl_Khoa dựa trên mã khoa nhập từ bàn phím
    public static void deleteKhoaRecordByMaKhoa() {
        try (Connection connection = DB_Connection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã khoa cần xóa: ");
            String maKhoaToDelete = scanner.nextLine();

            String sql = "DELETE FROM tbl_Khoa WHERE MaKhoa=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, maKhoaToDelete);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Bản ghi đã được xóa thành công.");
                } else {
                    System.out.println("Không tìm thấy bản ghi để xóa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức xóa một bản ghi theo mã khoa
        deleteKhoaRecordByMaKhoa();
    }
}
