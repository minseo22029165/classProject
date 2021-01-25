package com.aia.firstspring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aia.firstspring.Util.AES256Util;
import com.aia.firstspring.Util.Sha256;
import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.dao.MybatisMemberDao;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.service.MailSenderSevice;

@Service
public class MemberRegService {
	
//	@Autowired
//	private MemberDao dao;
	
//	@Autowired // 주입받는다
//	private MybatisMemberDao dao;
	
	private MemberInterfaceDao dao;

	@Autowired
	private MailSenderSevice mailSenderService; 
	
	@Autowired
	private Sha256 sha256;
	
	@Autowired // 주입받는다.
	private SqlSessionTemplate template;
	
	@Autowired
	private AES256Util AES256Util;
	
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder;
		
	public int insertMember(Member member) {
		int result = 0;
		
		try {
			dao = template.getMapper(MemberInterfaceDao.class);
			//sha256 테스트를 위해 주석 처리
			//result = dao.insertMember(member);
			
			result = 1;			
			
			System.out.println("sha256.encrypt = " + sha256.encrypt(member.getPassword()));
			
			String ewp = AES256Util.encrypt(member.getPassword());
			String dwp = AES256Util.decrypt(ewp);
			
			System.out.println("AES256Util.encrypt" + ewp);
			System.out.println("AES256Util.decrypt = " + dwp);
			String securityPw = cryptPasswordEncoder.encode(member.getPassword());
			System.out.println("cryptPasswordEncoder.encode : " + securityPw);
			System.out.println("cryptPasswordEncoder.matches : " + cryptPasswordEncoder.matches(member.getPassword(), securityPw));
			
			String html = "<h1>아래 링크를 통해 인증해주세요 <br><a href=\"http://localhost:8080/firstspring\">인증하기</a></h1>";
			
			// 메일 전송
			//mailSenderService.mailSend(member.getMemberid(), member.getMembername(), "[안내] 회원 가입을 위한 계정 인증 안내", html);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}	

}
