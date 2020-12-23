package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
							ServletResponse response, 
							FilterChain chain)
			throws IOException, ServletException {
		// 로그인 여부를 확인하는 filter
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		//boolean loginCheck = false;
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			// 정상실행 
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginForm.html"); 
			// 정상실행하지 않고 다른페이지로 이동
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
