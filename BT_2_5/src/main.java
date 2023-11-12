/*
 Cho cơ sở dữ liệu MySQL QLSV(Quản lý sinh viên) có bảng tbl_Khoa (id, MaKhoa, 
TenKhoa). Thực hiện các yêu cầu sau:
a. Viết phương thức DB_Connection() để kết nối cơ sở dữ liệu đó. 
b. Viết một phương thức để sửa một bản ghi có MaKhoa= “Kh02”. Giá trị các 
trường trong bản ghi cần sửa được nhập từ bàn phím.
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

    // Phương thức sửa một bản ghi trong bảng tbl_Khoa dựa trên MaKhoa nhập từ bàn phím
    public static void updateKhoaRecordByMaKhoa() {
        try (Connection connection = DB_Connection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập giá trị mới cho trường MaKhoa: ");
            String newMaKhoa = scanner.nextLine();

            System.out.print("Nhập giá trị mới cho trường TenKhoa: ");
            String newTenKhoa = scanner.nextLine();

            String sql = "UPDATE tbl_Khoa SET TenKhoa=? WHERE MaKhoa=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newTenKhoa);
                preparedStatement.setString(2, "Kh02"); // Điều kiện sửa dựa trên MaKhoa = "Kh02"

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Bản ghi đã được sửa thành công.");
                } else {
                    System.out.println("Không tìm thấy bản ghi để sửa.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức sửa một bản ghi theo MaKhoa
        updateKhoaRecordByMaKhoa();
    }
}
