package com.aia.op.member.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
	
		// 로그인 여부를 확인하고 
		// 로그인상태 -> return true
		// 비로그인상태 -> return false, 로그인페이지로 redirect 
		
		// session이 null일때 그대로 유지하기 위해서 false 전달 
		HttpSession session = request.getSession(false);    
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/member/login");
		return false;
		
	}

}
