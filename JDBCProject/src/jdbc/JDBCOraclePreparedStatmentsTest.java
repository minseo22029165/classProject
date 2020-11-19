package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOraclePreparedStatmentsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
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
			
			
			String sqlInsert = "insert into dept values (SEQ_DEPT_DEPTNO.NEXTVAL, ?, ?)";
			
			// PreparedStatement 인스턴스 생성 : sql 먼저 등록하고 사용한다.
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, userDname);
			pstmt.setString(2, Loc);			
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			}else {
				System.out.println("데이터 입력 실패.");
			}
			
			System.out.println("검색하고자 하는 부서의 이름을 입력해주세요. ");
			String searchDname = sc.nextLine();
			
			// 부서 정보 리스트 
			String sqlSelect = "select * from dept where dname=? order by loc";
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, searchDname);
			
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("검색 결과가 없습니다. ");
			}else {
				do {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\n");
				}while(rs.next()); 
			}
			
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
