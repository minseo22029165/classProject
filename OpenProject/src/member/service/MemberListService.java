package member.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberListView;

public class MemberListService {

	// 싱글톤
	private MemberListService() {}
	private static MemberListService service = new MemberListService();
	public static MemberListService getInstance() {
		return service;
	}
	
	// 페이지 번호는 request 받을 수 있다. request를 전달 받아 페이지하나를 표현하는 데이터를 생성하고 -> MemberListView 객체 생성 
	// MemberListView 객체를 view 페이지로 전달 
	public void getMemberListView(HttpServletRequest request) {
		MemberListView listView = null;
		
		Connection conn = null;
		MemberDao dao = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			int memberTotalCount = dao.selectMemberTotalCount(conn);
			
			// 페이지에 표현할 회원의 수 
			int memberCountPerPage = 3;

			// 현재 페이지 번호 
			int pageNumber = 1;
			
			try {
				pageNumber = Integer.parseInt(request.getParameter("page"));
			}catch (Exception e) {
			}
			
			// 구하고자 하는 범위의 첫번째 행 
			int firstRow = (pageNumber -1) * memberCountPerPage;

			// member객체를 저장하는 list 
			List<Member> memberList = dao.selectMember(conn, firstRow, memberCountPerPage);
			
			listView = new MemberListView(memberTotalCount, memberCountPerPage, memberList, firstRow, pageNumber);
					
		}catch (SQLException e) {
		}catch (Exception e) {
		}
		
		request.setAttribute("listView", listView);

	}
	
}
