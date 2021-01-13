package com.aia.firstspring.member.dao;

import java.util.List;

import com.aia.firstspring.member.domain.LoginRequest;
import com.aia.firstspring.member.domain.Member;

public interface MemberInterfaceDao {
	// abstract public 생각되어 있음 
	List<Member> selectMemberList();
	
	int insertMember(Member member);
	
	int totalCnt();
	
	List<Member> selectByIdPw(LoginRequest loginRequest);
	
	int deleteMember(int idx);
}
