import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectRecords {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnector.connect()) {
            String sql = "SELECT * FROM ten_bang";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thực hiện câu lệnh SELECT
                ResultSet resultSet = preparedStatement.executeQuery();
                
                // Xử lý kết quả
                while (resultSet.next()) {
                    String col1 = resultSet.getString("cot1");
                    int col2 = resultSet.getInt("cot2");
                    // ...
                    System.out.println(col1 + ", " + col2 + ", ...");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
