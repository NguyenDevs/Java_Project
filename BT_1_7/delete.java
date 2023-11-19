import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.connect()) {
            String sql = "DELETE FROM ten_bang WHERE dieu_kien";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thực hiện câu lệnh DELETE
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " bản ghi đã được xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
