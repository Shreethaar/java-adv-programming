public class MainClass {
	private static String DATABASE_EXCEPTION="DATABASE_EXCEPTION";
	private static final Logger logger = Logger.getLogger(MainClass.class);

	public static void main(String[] args) {
		try {
			makeDatabaseConnection();
		}
		catch(HandledException e) {
			rollbar.error(e,"Hello, Rollbar");
			System.out.println("Code: " + e.getCode()+" Exception Message : "+e.getMessage());
			logger.error("Exception: ", e);
		}
	}
	static void makeDatabaseConnection() throws HandledException {
		String dbURL = "jdbc:sqlserver://localhost\sqlexpress";
		String userName = "sa";
        	String password = "secret";
        	Connection conn = null;

		try {
			conn = DriverManager.getConnection(dbURL, userName, password);
		}
		catch(SQLException e) {
			rollbar.error(e,"Hello,Rollbar");
			throw new HandledException(DATABASE_EXCEPTION,"Failed to connect to database", e);
		}
	}
}

