import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	private static final String URL = "jdbc:mariadb://localhost:3306/testdb";
	private static final String USER = "testuser";
	private static final String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = conn.createStatement();
			String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT)";
			stmt.executeUpdate(createTableSQL);
			String insertDataSQL = "INSERT INTO users (name, age) VALUES ('Alice', 30)";
			stmt.executeUpdate(insertDataSQL);
			String insertPreparedSQL = "INSERT INTO users (name, age) VALUES (?, ?)";
           		 PreparedStatement pstmt = conn.prepareStatement(insertPreparedSQL);
            		pstmt.setString(1, "Bob");
           		pstmt.setInt(2, 25);
            		pstmt.executeUpdate();

			String selectSQL="SELECT id,name,age FROM users";
			ResultSet rs = stmt.executeQuery(selectSQL);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
			}

			rs.close();
			pstmt.close();
			stmt.close();
			conn.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

