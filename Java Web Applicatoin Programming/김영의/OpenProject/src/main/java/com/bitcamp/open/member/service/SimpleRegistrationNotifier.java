package com.bitcamp.open.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.open.member.model.Member;

public class SimpleRegistrationNotifier {

	@Autowired
	private MailSender mailSender;

	public void sendMail(Member member) {
		// SimpleMailMessage(메일 제목, 단순 텍스트 내용)를 전달받아 메일을 발송하는 기능을 정의
		// 보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입 안내]" + member.getMember_name() + "님 회원가입을 축하합니다.");
		message.setFrom("duddml42@gmail.com");
		message.setText("회원가입 완료");
		message.setTo(member.getMember_id());

		/*
		 * //메일 보내기 설정 SimpleMailMessage message = new SimpleMailMessage(); //제목설정
		 * message.setSubject(member.getMember_name()+"님 회원가입을 감사드립니다."); //내용설정
		 * message.setText(member.getMember_name()+"님 회원가입을 감사드립니다."); //가입회원의 메일 주소 설정
		 * message.setTo(member.getMember_id()); //보내는 메일 설정
		 * message.setFrom("duddml42@gamil.com");
		 */

		mailSender.send(message);
	}

	public void sendMail(String email) {
		// 보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입 안내] 회원가입을 축하합니다.");
		message.setFrom("duddml42@gmail.com");
		message.setText("회원가입 완료");
		message.setTo(email);

		mailSender.send(message);
	}

	public void sendMail(String email, String msg) {
		// 보내는 정보를 SimpleMailMessage 객체에 담는다.
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원가입 안내] 회원가입을 축하합니다.");
		message.setFrom("duddml42@gmail.com");
		message.setText(msg);
		message.setTo(email);

		mailSender.send(message);
	}
}
