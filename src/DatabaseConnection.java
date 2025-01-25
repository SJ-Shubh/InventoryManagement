import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/db_config.properties"));
                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
