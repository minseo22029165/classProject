package member.service;

import javax.annotation.Resource;

import member.dao.Dao;
//import member.dao.MemberDao;

public class MemberRegService3 implements MemberService {
	
	@Resource(name = "guestDao")
	private Dao dao; // 주입받아야 하는 참조 변수
	

	public Object process() {
		System.out.println("MemberRegService 실행");
		dao.insert();
		return null;		
	}

}
