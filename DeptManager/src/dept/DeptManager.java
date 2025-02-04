package dept;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeptManager {
	
	// 사용자 입력
	Scanner sc = new Scanner(System.in);
	
	DeptDao dao = DeptDao.getInstance();

	private boolean Dept;
	
	// 부서입력 메소드  : 사용자에게 입력받은 데이터를 DAO를 이용해서 DB처리
	void insertDept() {
		
		// 부서정보를 받아서 인스턴스를 생성하고 dao.insertDept()
		System.out.println("부서번호 입력 >> ");
		String deptno = sc.nextLine();
		System.out.println("부서이름 입력 >> ");
		String dname = sc.nextLine();
		System.out.println("지역이름 입력 >> ");
		String loc = sc.nextLine();
		
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		
		Connection conn = null;
		int resultCnt = 0;
		
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
			
			resultCnt = dao.insertDept(dept, conn);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultCnt > 0) {
			System.out.println("입력 완료");
		}else {
			System.out.println("입력 실패");			
		}
	}
	
	// 부서 정보 수정 메소드 : 사용자에게 입력 받고 데이터를 DAO를 이용해서 수정
	void editDept() {
		System.out.println("수정할 부서번호 입력 >>");
		String deptno = sc.nextLine();
		System.out.println("수정할 부서이름 입력 >> ");
		String dname = sc.nextLine();
		System.out.println("수정할 지역이름 입력 >> ");
		String loc = sc.nextLine();		
		
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		
		Connection conn = null;
		
		int resultCnt = 0;
		
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
				
			resultCnt = dao.updateDept(dept, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultCnt > 0) {
			System.out.println("수정 완료");
		}else {
			System.out.println("수정 실패");			
		}		

	}
	
	// 부서 정보 삭제
	void delDept() {
		System.out.println("삭제할 부서번호 입력 >>");
		String deptno = sc.nextLine();
		
		Connection conn = null;
		
		int resultCnt = 0;
		
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
			
			resultCnt = dao.deleteDept(Integer.parseInt(deptno), conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultCnt > 0) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");			
		}			
	}
	
	// 
	void listDept() {
		Connection conn = null;

		List<Dept> list = null;
		
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
				
			list = dao.listDept(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.isEmpty()) {
			System.out.println("정된 정보가 없습니다.");
		}else {
			for(Dept d : list) {
				System.out.printf("%5s" + d.getDeptno() + "\t");
				System.out.printf("%12s" + d.getDname() + "\t");
				System.out.printf("%12s" + d.getLoc() + "\t");
				
			}	
		}					
	}
	
	void searchDept() {
		System.out.println("조회할 부서번호 입력 >>");
		String deptno = sc.nextLine();
		
		Connection conn = null;
		
		Dept dept = null;
		
		
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
				
			dept = dao.searchDept(Integer.parseInt(deptno), conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dept==null) {
			System.out.println(dept);
		}else {
			System.out.println("찾으시는 정보가 존재하지 않습니다.");			
		}			
	}
}
