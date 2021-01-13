package com.aia.firstspring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.firstspring.member.service.MemberDelService;

@Controller
@RequestMapping("/member/del")
public class MemberDelController {
	
	@Autowired
	private MemberDelService delService;

	@RequestMapping(method = RequestMethod.GET)
	public String memberDel(int idx, Model model) {
		model.addAttribute("resultCnt", delService.deleteMember(idx));
		return "member/del";
	}
	
}
