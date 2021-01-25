package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.service.MailSenderSevice;

@Controller
@RequestMapping("/mail")
public class MailSenderController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage templateMessage;
	
	private MailSenderSevice mailSenderService;
	
	@RequestMapping("/simplemail")   // /mail/simplemail
	public void simpleMailSend() {
		
		// 직접 보내는 경우 
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("dittosjai@gmail.com");
//		message.setSubject("테스트 이메일 발송입니다.");
//		message.setText("내용입니다.");
//		mailSender.send(message);
		
		
		// 템플릿을 servlet-context에 등록해 놓고 보내는 경우
//		SimpleMailMessage message = new SimpleMailMessage(templateMessage);
//		message.setTo("dittosjai@gmail.com");
//		mailSender.send(message);		
		
		// 함수 이용
		//mailSenderService.simpleMailSend();
		
		//mailSenderService.mailSend("dittosjai@gmail.com");
	}
}
