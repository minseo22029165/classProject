package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// DAO : Data Access Object -> 데이터 베이스 처리하는 기능만 가지를 클래스
public class DeptDao {
	private static DeptDao dao = new DeptDao();
	
	private DeptDao() {
		
	}
	
	public static DeptDao getInstance() {
		return dao;
		
	}

	// 부서입력
	int insertDept(Dept dept, Connection conn){
		int resultCnt = 0;

		try {
			// db연결 
			
			// SQL : insert
			String sql = "insert into dept values (?, ?, ?)";
			
			// statement			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			// sql실행
			resultCnt = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 결과
		return resultCnt;
	}
	
	// 부서정보를 수정
	int updateDept(Dept dept, Connection conn){
		int resultCnt = 0;

		try {
			// db연결 
			
			// SQL : insert
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			
			// statement			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			// sql실행
			resultCnt = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 결과
		return resultCnt;		
	}
	
	// 부서정보를 삭제
	int deleteDept(int deptno, Connection conn){
		int resultCnt = 0;
		try {
			// db연결 
			
			// SQL : insert
			String sql = "delete from dept where deptno = ?";
			
			// statement			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			// sql실행
			resultCnt = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// 결과
		return resultCnt;	
	}
	
	//부서의 전체리스트
	List<Dept> listDept(Connection conn) {
		List<Dept> list = new ArrayList<Dept>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from dept order by deptno";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//Dept d = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
				//list.add(d);
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// 부서 하나 검색
	Dept searchDept(int deptno, Connection conn){
		Dept dept = null;
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from dept where deptno = " + deptno;
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dept;		
	}




}
