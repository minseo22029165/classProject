package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingCommand extends Command {

	@Override
	public String getViewPage(HttpServletRequest reqeust, HttpServletResponse response) {
		// 사용자의 요청을 처리하고 응답에 필요한 데이터를 request 속성에 저장, 응답에 필요한 설정 
		// 이 요청의 응답처리를 위한  view 페이지 경로를 반환 
		String viewPage = null;
		
		// 사용자 요청의 처리 
		String result = "환영합니다. 요청하신 경로는 " + reqeust.getRequestURI();
		
		reqeust.setAttribute("result", result);
		
		return "/view/greeting.jsp";
	}

}
