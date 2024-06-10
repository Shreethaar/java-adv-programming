import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.MariaDbDataSource;

public class Service {
	private static Service instance;
	private DataSource dataSource;

	private Service() throws SQLException {
		MariaDbDataSource dataSource = new MariaDbDataSource();
		dataSource.setUrl("jdbc:mariadb//localhost:3306/demo");
		dataSource.setUser("user");
		dataSource.setPassword("Password123!");
		this.dataSource=dataSource;

	}

	public static synchronized Service getInstance() throws SQLException {
		if(instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public List<Strings> getAllProgrammingLanguage() throws SQLException {
		var list = new ArrayList<String>();
		try(Connection connection = dataSource.getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT pl_name FROM programming_language")) {
				Result resultSet = statement.executeQuery();
				while(resultSet.next()) {
					list.add(resultSet.getString("pl_name"));
				}
			}
		}
		return list;
	}
}

