import java.sql.*;

public class AgentDB {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/etalon";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "ItsMyLife0203";
    private Connection connection;

    public AgentDB() {
        try {
            System.out.println("12");
            Class.forName(DB_DRIVER);
            System.out.println("14");
            this.connection = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("connection established");
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC-driver not found: connection failed");
            throw new RuntimeException(e);
        }
    }

    public AgentDB(String url) {
        try {
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(url);
            System.out.println("connection established");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC-driver not found: connection failed");
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

    public void closeConnection() throws SQLException {
        this.connection.close();
        System.out.println("connection closed");
    }
}
