package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.LoginInfo;
import member.model.Member;
import util.CookieBox;

public class MemberLoginService {

	// 싱글톤
	private MemberLoginService() {}
	private static MemberLoginService service = new MemberLoginService();
	public static MemberLoginService getInstance() {
		return service;
	}
	
	// request, response 전달받고
	// 사용자 입력 데이터 id,pw 로그인 처리, 아이디 저장 
	// session=request.getSession()
	public void memberLogin(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String chk = request.getParameter("chk");
		
		//System.out.println( chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty() );
		
		if(chk!= null &&chk.equals("on") && userId != null && !userId.isEmpty()){
			
			// 쿠키 생성 저장
			// uid = userId
			//System.out.println( userId );
			response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
			
		} else {
			response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
		}
		
		// session 추가
		// id, pw 비교해서 같으면 로그인 성공, 다르면 실패
		boolean loginChk = false;
		
		MemberDao dao = null;
		Connection conn = null;
				
		try {
		 	dao = MemberDao.getInstance();
		 	conn = ConnectionProvider.getConnection();
			Member member = dao.selectMemberLogin(conn, userId, pw);
			
			
			if (member != null){
				//System.out.println(member);
				LoginInfo loginIfo = member.toLoginInfo();
				
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", loginIfo);
				
				//System.out.println(loginIfo);
				loginChk = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("loginChk", loginChk);
	}

}
