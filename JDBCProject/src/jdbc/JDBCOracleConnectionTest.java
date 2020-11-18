package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracleConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Load!!!");
			
			// 2. db 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("접속완료.");
			
			conn.close();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
