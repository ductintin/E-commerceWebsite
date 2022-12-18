package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
	private final String serverName = "localhost";
	private final String dbName = "LTW";
	private final String portNumber = "1433";
	private final String instance = " ";
	private final String userID = "sa";
	private final String password = "12345678";

	// Định
//	private final String serverName = "DESKTOP-8M4OG13";
//	private final String dbName = "LTW";
//	private final String portNumber = "1433";
//	private final String instance = " ";
//	private final String userID = "sa";
//	private final String password = "123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName
				+ ";encrypt=true;trustServerCertificate=true;";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=true;trustServerCertificate=true;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new ConnectJDBC().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
