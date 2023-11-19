import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.connect()) {
            String sql = "INSERT INTO ten_bang (cot1, cot2, ...) VALUES (?, ?, ...)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thiết lập giá trị cho các tham số
                preparedStatement.setString(1, "GiaTri1");
                preparedStatement.setInt(2, 123);
                // ...
                
                // Thực hiện câu lệnh INSERT
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " bản ghi đã được thêm.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
