package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain2 {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		
		Dao dao1 = ctx.getBean("memberDao", Dao.class);
		Dao dao2 = ctx.getBean("memberDao", Dao.class);
		
		System.out.println("dao1==dao2 => " + (dao1==dao2));
		
		// 2. MemberRegService 객체가 필요
		MemberRegService regService1 = ctx.getBean("memberRegService", MemberRegService.class);
		MemberRegService regService2 = ctx.getBean("memberRegService", MemberRegService.class);
		
		// scope="prototype" 이면 false  prototype : 빈을 요청할 때마다 빈 객체를 생성한다.
		System.out.println("regService1==regService2 => " + (regService1==regService2));
		
		// 4. MemberInfoService 객체
		MemberInfoService infoService1 = ctx.getBean("memberInfoService", MemberInfoService.class);
		MemberInfoService infoService2 = ctx.getBean("memberInfoService", MemberInfoService.class);
		
		// scope="singleton" 이면 true  singleton : 컨테이너에 한 개의 빈 객체만 생성한다.(기본값)
		System.out.println("infoService1==infoService2 => " + (infoService1==infoService2));

	}

}