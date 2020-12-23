package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.Member;

public class MemberDao {

	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 데이터 입력
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		Statement stmt = null;
		
		String sqlInsert = "INSERT INTO member (memberid, password, membername) VALUES ('" + member.getUserId() + "', '" + member.getPassword() + "', '" + member.getUserName() + "')";
		
		try {
			stmt = conn.createStatement();
			resultCnt = stmt.executeUpdate(sqlInsert);
			stmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return resultCnt;
	}

	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		Member member = null;
		Statement stmt = null;
		
		String sqlSelect = "SELECT * FROM member where memberid= '" + uid + "' and password= '" + pw + "'";
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
				
			if(rs.next()){
				member = new Member(rs.getString("memberid"),rs.getString("password"),rs.getString("membername"),rs.getString("memberphoto")); 		
			}
			stmt.close();
			conn.close();	
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
		
		
	}
}


