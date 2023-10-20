import java.sql.*;

public class AgentDB {
    private static final String DB_URL = "";
    private static final String DB_DRIVER = "";
    private Connection connection;

    public AgentDB(String url) {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(url);
            System.out.println("connection established");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC-driver not found!\nconnection failed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection failed");
        }
    }

    public AgentDB(String url, String name, String password) {
        try {
            this.connection = DriverManager.getConnection(url, name, password);
            System.out.println("connection established");
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
    }
}
