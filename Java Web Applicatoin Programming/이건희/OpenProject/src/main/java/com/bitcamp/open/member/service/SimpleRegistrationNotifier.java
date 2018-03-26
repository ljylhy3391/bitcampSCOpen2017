package com.bitcamp.open.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.open.member.Model.Member;

public class SimpleRegistrationNotifier {

	@Autowired//클래스 객체 의존주입
	private MailSender mailSender;
	
	public void sendMail(Member member) {
		SimpleMailMessage message = new SimpleMailMessage();
		//제목설정
		message.setSubject(member.getMember_name()+"님 회원가입을 감사드립니다");
		//내용 설정
		message.setText(member.getMember_name()+"님 회원가입을 감사드립니다");
		//가입회원의 메일주소 설정 
		message.setTo(member.getMember_id());
		//보내는 메일 설정 
		message.setFrom("dlrjsgmlv39@gmail.com");
		
		mailSender.send(message);
		

	}
	

	public void sendMail(String email,String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		//보내는 정보를  SimpleMailMessage message 객체에 담는다 .
		
		message.setSubject(email+"님 로그인 되셨습니다"); 
		message.setFrom("dlrjsgmlv39@gmail.com"); //발신자  xml에 설정해놨으므로 다른값이 들어가도 상관없음
		message.setText(msg);
		message.setTo(email); // 받는사람  []형태의 setTo를 사용해됨
	

		mailSender.send(message);//담아서 보냄  
		
		
	}
	
}
