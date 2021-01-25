package com.aia.firstspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aia.firstspring.domain.MemberRegRequest;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.member.service.MemberListService;
import com.aia.firstspring.member.service.MemberRegService;
import com.aia.firstspring.member.service.MemberRestService;

@RestController
@RequestMapping("/rest/ver1/members")
public class RestApiController {
	
	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberListService listService; 
	
	@Autowired
	private MemberRegService regService;
	
//	@GetMapping("/{idx}")   // /rest/ver1/members/idx
//	public String getRest(@PathVariable("idx") int idx) {
//		
//		return "@RestApiController 사용한 응답처리 : " + idx;
//	}
	
	// getMemberList를 json 형식으로 반환 
	@GetMapping   // /rest/ver1/members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}
	
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping  // 둘중에 하나만 쓰면됨 
	public String insertMember(
			@RequestBody MemberRegRequest regRequest
			) {
		
		String result = "N";
		
		System.out.println(regRequest);
//		System.out.println(regRequest.getToMember());
		
		if(regService.insertMember(regRequest.getToMember()) > 0) {
			result = "Y";
		}

		return result;
	}
	
	// 실제로 uri 구성할때는 이런식으론 하지 않는다. 그저 예제일 뿐이다. 
	@GetMapping("/map")   // /rest/ver1/members/map
	public Map<Integer, Member> getMemberListMap(){
		Map<Integer, Member> memberMap = new HashMap<Integer, Member>();
		
		for(Member member : listService.getMemberList()) {
			memberMap.put(member.getIdx(), member);
		}
		return memberMap;
	}
	
	@GetMapping("/{idx}")
	public Member getMemberInfo(
			// @PathVariable("idx")는 @GetMapping("/{idx}") 이거랑 변수명이 같아야한다.
			@PathVariable("idx") int idx  
			) {
		return restService.getMember(idx);
	}

}