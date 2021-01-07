package com.aia.firstspring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberSearchController {
	
	@RequestMapping("/member/search")
	public String searchMember(	//@RequestParam("p") int pageNumber,
								@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			
								//@RequestParam("uid") String uid,
								@RequestParam(value = "uid", required = false) String uid,   // required = false : 
								//@RequestParam("name") String name
								@RequestParam(value = "name", required = false) String name   // required = false : 
								) {
		
		System.out.println("p=" + pageNumber);
		System.out.println("uid=" + uid);
		System.out.println("name=" + name);
		return "member/search";  // view 이름 : view의 경로
	}

}
