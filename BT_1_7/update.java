import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecord {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.connect()) {
            String sql = "UPDATE ten_bang SET cot1 = ?, cot2 = ? WHERE dieu_kien";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thiết lập giá trị mới cho các cột
                preparedStatement.setString(1, "GiaTriMoi1");
                preparedStatement.setInt(2, 456);
                // ...

                // Thực hiện câu lệnh UPDATE
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " bản ghi đã được cập nhật.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
