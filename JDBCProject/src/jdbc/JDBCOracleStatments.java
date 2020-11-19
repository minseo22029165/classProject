package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOracleStatments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		// 사용자에게 데이터를 받는다.
		Scanner sc = new Scanner(System.in);		
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Load!!!");
			
			// 2. db 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			// 3. statment 인스턴스 생성 
			Statement stmt = conn.createStatement();
			
			System.out.println("부서 이름을 입력해주세요 ");
			String userDname = sc.nextLine();
			System.out.println("부서 위치를 입력해주세요 ");
			String Loc = sc.nextLine();
			
			
			// 입력 : insert
			String sqlInsert = "insert into dept values (SEQ_DEPT_DEPTNO.NEXTVAL, '" + userDname + "', '" + Loc + "')";
			
			int resultCnt = stmt.executeUpdate(sqlInsert);
			
			// 데이터 한행이 정상적으로 삽입된 경우 : 1  
			if(resultCnt > 0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			}
			
			// 4. sql실행 : 부서 리스트 출력
			String sql = "select * from dept";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			// 5. ResultSet 이용하여 결과출력
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString(3);
				
				System.out.println(deptno + "\t" + dname + "\t" + loc);				
			} 
			
			// 6. close
			rs.close();
			stmt.close();
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
