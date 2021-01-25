package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.domain.Member;
import com.aia.op.member.domain.SearchParam;

public interface MemberDao {
	
	// public abstract 
	// 회원 등록 
	int insertMember(Member member);

	// 로그인 
	Member selectLogin(String id, String pw);
	
	// 회원의 총 수
	int selectTotalCount();

	// 회원리스트(페이지 번호에 맞는)
	//List<Member> selectMemberList(int startRow, int cntPerPage);
	List<Member> selectMemberList(Map<String, Object> param);

	//int selectSearchMemberCount(SearchParam param);
	int selectSearchMemberCount(Map<String, Object> listMap);

	// 회원 정보 삭제
	int deleteMemberByIdx(int idx);

	// 회원 정보 조회 : idx로 조회 
	Member selectMemberByIdx(int idx);

	// 회원정보 수정 
	int updateMember(Member member);
	
	// id 존재 유무 확인
	int selectMemberByIdCount(String id); 
	
	// idx, verify 조회 
	int selectMemberByIdxVerify(int idx); 
	
	// 인증처리 verify = 'Y'
	int updateMemberVerify(int idx, String code);

	
}
