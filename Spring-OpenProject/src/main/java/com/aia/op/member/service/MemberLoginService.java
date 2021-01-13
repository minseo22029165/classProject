package com.aia.op.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.domain.Member;

@Service  // bean 에 등록됨 
public class MemberLoginService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public boolean login(	HttpServletRequest request,
							HttpServletResponse response
						) {
		boolean loginCheck = false;
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String chk = request.getParameter("chk");
		
		// 1. dao -> id, pw 데이터로 검색 , 존재하면 로그인 처리
		dao = template.getMapper(MemberDao.class);
		
		Member member = dao.selectLogin(id, pw);
		
		if(member != null) {
			// 현재 세션 속성에 LoginIfo 인스턴스를 저장 
			request.getSession().setAttribute("loginInfo", member.toLoginInfo());
			
			if(chk!=null && chk.equals("on")) {
				// 쿠키 생성
				Cookie c = new Cookie("uid", id);
				c.setMaxAge(60*60*24*365);
				response.addCookie(c);
			}else {
				// 쿠키 소멸 
				Cookie c = new Cookie("uid", id);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			
			loginCheck = true;
			
		} else {
			
		}
		
		return loginCheck;
	}  
}
