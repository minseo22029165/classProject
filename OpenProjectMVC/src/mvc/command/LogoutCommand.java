package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberLoginService;

public class LogoutCommand implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// 로그아웃 서비스 
		request.getSession().invalidate();
		
		return "/WEB-INF/view/index.jsp";
	}

}
