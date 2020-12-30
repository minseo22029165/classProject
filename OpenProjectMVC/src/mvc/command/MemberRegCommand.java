package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberRegService;

public class MemberRegCommand implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// MemberRegService(HttpServletRequest request)  -> int 1 or 0
		MemberRegService service = MemberRegService.getInstance();
		try {
			service.insertMember(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/WEB-INF/view/member/memberRegView.jsp";
	}

}
