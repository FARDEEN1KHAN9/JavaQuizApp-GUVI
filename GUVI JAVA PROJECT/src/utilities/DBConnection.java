package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Utility class to manage database connections.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/quizguvi";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
