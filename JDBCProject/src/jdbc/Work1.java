package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Work1 {

	public static void main(String[] args) {
		Connection conn = null;
		// 입력 Scanner
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			Statement stmt = conn.createStatement();
			
			String empno = "", name = "", job = "", mgr = "", hireDate = "", sal = "", comm = "", deptno = "", dname = "", loc = "";
			int resultCnt = 0;
			
			
/*
			// 1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
		
			System.out.print("사원명을 입력하세요 >> ");
			name = sc.nextLine();
			System.out.print("직업을 입력하세요 >> ");
			job = sc.nextLine();
			System.out.print("상사 직원번호를 입력하세요(입력안할 경우 엔터) >> ");
			mgr = sc.nextLine();
			if (mgr.trim().equals(null) || mgr.trim().equals("")) {
				mgr = "null";
			}
			System.out.print("월급을 입력하세요 >> ");
			sal = sc.nextLine();
			System.out.print("커미션금액을 입력하세요(입력안할 경우 엔터) >> ");
			comm = sc.nextLine();
			if (comm.trim().equals(null) || comm.trim().equals("")) {
				comm = "null";
			}			
			System.out.print("부서번호를  입력하세요 (10:ACCOUNTING, 20:RESEARCH, 30:SALES, 40:OPERATIONS) >> ");
			deptno = sc.nextLine();
			
			String strInsert = "INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) "
					+ " VALUES (SEQ_EMP_DEPTNO.NEXTVAL, '" + name + "', '" + job + "', " + mgr + ", SYSDATE, " + sal + ", " + comm + ", " + deptno + ")";
			
			
			//System.out.println(strInsert);
			resultCnt = stmt.executeUpdate(strInsert);
			
			if(resultCnt > 0) {
				System.out.println("EMP 테이블 정상 입력 완료.");
			} else {
				System.out.println("EMP 테이블 정상 입력 실패.");
			}

			
			// 2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
			String sqlSelect = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			if(rs.next()) {
				System.out.println("사원번호\t사원명 \t직업 \t상사\t사원번호\t입사일\t월급\t커미션\t부서번호");				
				do {
					empno = rs.getString("EMPNO");
					name = rs.getString("ENAME"); 
					job = rs.getString("JOB");
					mgr = rs.getString("MGR");
					hireDate = rs.getString("HIREDATE");
					sal = rs.getString("SAL");
					comm = rs.getString("COMM");
					deptno = rs.getString("DEPTNO");
					
					System.out.println(empno + "\t" + name + "\t " + job + "\t" + mgr 
										+ "\t" + hireDate + "\t " + sal + "\t" + comm + "\t" + deptno);
					
				}while(rs.next());
			}else {
				System.out.println("EMP 데이터가 존재하지 않습니다.");
			}
			
			// 3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
			String strUpdate = "UPDATE EMP SET SAL = 1000 WHERE ENAME = 'SCOTT'";
			
			resultCnt = stmt.executeUpdate(strUpdate);
			
			if(resultCnt > 0) {
				System.out.println("EMP 테이블 정상 수정 완료.");
			} else {
				System.out.println("EMP 테이블 정상 수정 실패.");
			}		
			
			
			// 4. EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
			String sqlSelect = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP WHERE ENAME = 'SCOTT'";
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			if(rs.next()) {
				System.out.println("사원번호\t사원명 \t직업 \t상사\t사원번호\t입사일\t월급\t커미션\t부서번호");				
				do {
					empno = rs.getString("EMPNO");
					name = rs.getString("ENAME"); 
					job = rs.getString("JOB");
					mgr = rs.getString("MGR");
					hireDate = rs.getString("HIREDATE");
					sal = rs.getString("SAL");
					comm = rs.getString("COMM");
					deptno = rs.getString("DEPTNO");
					
					System.out.println(empno + "\t" + name + "\t " + job + "\t" + mgr 
										+ "\t" + hireDate + "\t " + sal + "\t" + comm + "\t" + deptno);
					
				}while(rs.next());
			}else {
				System.out.println("EMP 데이터가 존재하지 않습니다.");
			}			
			
*/			
			// 5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
			String sqlSelect = "SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO, D.DNAME, D.LOC";  
			sqlSelect = sqlSelect + "  FROM EMP E"; 
			sqlSelect = sqlSelect + "    INNER JOIN DEPT D ON E.DEPTNO = D.DEPTNO"; 
					
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			if(rs.next()) {
				System.out.println("사원번호\t사원명 \t직업 \t상사\t사원번호\t입사일\t월급\t커미션\t부서번호\t부서명\t위치");				
				do {
					empno = rs.getString("EMPNO");
					name = rs.getString("ENAME"); 
					job = rs.getString("JOB");
					mgr = rs.getString("MGR");
					hireDate = rs.getString("HIREDATE");
					sal = rs.getString("SAL");
					comm = rs.getString("COMM");
					deptno = rs.getString("DEPTNO");
					dname = rs.getString("DNAME");
					loc = rs.getString("LOC");					
					
					System.out.println(empno + "\t" + name + "\t " + job + "\t" + mgr 
										+ "\t" + hireDate + "\t " + sal + "\t" + comm + "\t" + deptno + "\t" + dname + "\t" + loc);
					
				}while(rs.next());
			}else {
				System.out.println("EMP 데이터가 존재하지 않습니다.");
			}						
			rs.close();
			stmt.close();
			conn.close();
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
