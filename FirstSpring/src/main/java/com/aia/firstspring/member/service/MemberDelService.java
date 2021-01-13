package com.aia.firstspring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.aia.firstspring.member.dao.MemberInterfaceDao;

public class MemberDelService {
	
	private MemberInterfaceDao dao;
	
	@Autowired // 주입받는다. 
	private SqlSessionTemplate template; 

	public int deleteMember(int idx) {
		int result = 0;

		dao = template.getMapper(MemberInterfaceDao.class);
		result = dao.deleteMember(idx);
		return result;
	}
}
