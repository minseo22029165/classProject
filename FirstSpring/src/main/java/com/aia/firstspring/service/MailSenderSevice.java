package com.aia.firstspring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderSevice {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean simpleMailSend() {
		boolean result = true;
		
		// 직접 보내는 경우 
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("dittosjai@gmail.com");
		message.setSubject("테스트 이메일 발송입니다.");
		message.setText("내용입니다.");
		
		try {
			mailSender.send(message);
		}catch (MailException e) {
			result = false;
		}
		
		return result;
	}
	
	
	// toEmailAddress : 받는 사람의 이메일 
	public boolean mailSend(String toEmailAddress, String name, String subject, String text) {
		boolean result = true;
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			// 메일 제목 
			message.setSubject(subject, "utf-8"); // 메일 제목
			// 메일 내용에 적용할 html 
			//String htmlStr = "<h1 style=\"color:red;\">회원가입을 축하합니다.</h1>";
			// 메일 내용 적용 
			message.setText(text, "utf-8", "html");
			
			// 보내는 사람의 이메일 : gmail을 사용하는 경우에는 인증된 메일로 적용이 된다.  
			message.setFrom(new InternetAddress("dittosjai@gmail.com"));  
			// 받는 사람의 이메일  
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, name + " 고객님", "utf-8"));
			// 메일 전송 
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		return result;
	}


	
}
