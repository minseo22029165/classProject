package dept;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String user = "bit";
		String password = "bit";
		
		return conn;
	}

}
