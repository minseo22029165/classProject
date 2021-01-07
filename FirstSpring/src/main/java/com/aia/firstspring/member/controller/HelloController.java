package com.aia.firstspring.member.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   // 이걸 해주어야 핸들러 클래스에 등록됨 
public class HelloController {
	// 메소드는 ViewName 반환, 반환타입을 ModelAndView 를 이용해서 반환 
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		
		// 리저브 안에서 보관하는 경로를 만들어줌 //WEB-INF/VIEW/member/hello.jsp
		mav.setViewName("member/hello");
		// 공유할 데이터 
		mav.addObject("greeting", greeting());
		return mav;		
	}

	private String greeting() {
		String result = "안녕하세요.";
		int nowTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(nowTime >= 6 && nowTime <= 10 ) {
			result = "좋은아침입니다.";
		} else if(nowTime >= 12 && nowTime <= 15) {
			result = "점심식사는 하셨나요?";
		} else if(nowTime >= 18 && nowTime <= 22) {
			result = "좋은밤 되세요.";
		}
		return result;
	}
	
}
