package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMysqlConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		
		try {
			// 1. 드라이버 로드(참조로 가져온 외부 jar파일 경로)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Oracle Driver Load!!!");
			
			// 2. db 연결 (serverTimezone=UTC 이거 반드시 넣어줘야함)
			String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
			String user = "bit";
			String password = "bit";
			
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
