/*
 2.1 Cho cơ sở dữ liệu MySQL QLSV(Quản lý sinh viên) có bảng tbl_login (id, name, 
pass). Thực hiện các yêu cầu sau:
a. Viết phương thức DB_Connection() để kết nối cơ sở dữ liệu đó. 
b. Viết một phương thức hiển thị danh sách các bản ghi trong bảng tbl_login lên 
hộp thoại hoặc màn hình Console. 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main{

    // Thay đổi thông tin kết nối tới cơ sở dữ liệu của bạn
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Phương thức kết nối đến cơ sở dữ liệu
    public static Connection DB_Connection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return connection;
    }

    // Phương thức hiển thị danh sách các bản ghi trong bảng tbl_login
    public static void displayLoginRecords() {
        try (Connection connection = DB_Connection()) {
            String sql = "SELECT id, name, pass FROM tbl_login";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("ID\tName\tPassword");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String pass = resultSet.getString("pass");
                    System.out.println(id + "\t" + name + "\t" + pass);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức hiển thị danh sách các bản ghi
        displayLoginRecords();
    }
}

