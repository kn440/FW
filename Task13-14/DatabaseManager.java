package hw_final2;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/homeanimal";
    private static final String USER = "root";
    private static final String PASSWORD = "Sedanka01"; // Замените на свой пароль

    public void addAnimal(Animal animal) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Animals (name, commands, color) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, animal.getName());
            stmt.setString(2, animal.getCommands());
            stmt.setString(3, animal.getColor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
