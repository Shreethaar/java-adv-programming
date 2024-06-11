import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDBTest {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/testdb";
        String user = "testuser";
        String password = "password";

        try {
            // Load the MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT 1");

            // Process the result set
            while (rs.next()) {
                System.out.println("Query Result: " + rs.getInt(1));
            }

            // Close the connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

