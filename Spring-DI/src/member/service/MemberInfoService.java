package member.service;

import member.dao.Dao;

public class MemberInfoService implements MemberService {
	
	Dao dao;

	// 생성자를 통해서 dao 타입의 인스턴스를 주입 받는다.
/*	
	public MemberInfoService(Dao dao) {
		this.dao = dao;
	}
*/
	// 프로퍼티 타입의 주입 방식 : setter 메소드 정의
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberInfoService  인스턴스 실행 ");
		
		dao.select();
		return null;
	}

}
