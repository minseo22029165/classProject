package com.aia.firstspring.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.domain.LoginRequest;
import com.aia.firstspring.member.domain.Member;

@Service
public class MemberLoginService {
	
//	@Autowired
//	MemberDao dao;
	
	private MemberInterfaceDao dao;
	
	@Autowired // 주입받는다.
	private SqlSessionTemplate template; 
	
	public List<Member> memberLogin(LoginRequest loginRequest) {
		dao = template.getMapper(MemberInterfaceDao.class);
		return dao.selectByIdPw(loginRequest);

	}

}
