package com.bitcamp.open.member.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.open.member.Model.Member;

public class SimpleRegistrationNotifier2 {

	@Autowired//클래스 객체 의존주입
	private JavaMailSender mailSender;
	
	
	public void sendMail(Member member) {
	
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			//제목설정
			message.setSubject("회원가입 안내");
			//내용설정
			String htmlMsg="<strong>안녕하세요"+member.getMember_name()+"님</strong>, 반갑습니다.";
			message.setText(htmlMsg,"utf-8","html");
			
			//보내는 메일 주소 
			message.setFrom(new InternetAddress(member.getMember_id()));
			//받는 메일 주소 
			message.addRecipient(RecipientType.TO, new InternetAddress(member.getMember_id()));
			mailSender.send(message);
		
		} catch (MessagingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

	public void sendMailAttach(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		
		
		try {
			//메일에 파일 첨부를 위해서  MimemessageHelper 클래스 이용, 생성자 매개변수(메세지,파일첨부여부,인코딩)
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,"UTF-8");
			//제목설정 
			messageHelper.setSubject("회원가입을 축하드립니다");
			//html 형태로 만들어줌 
			String htmlMsg="<strong>안녕하세요"+member.getMember_name()+"님</strong>, 반갑습니다.";
			messageHelper.setText(htmlMsg,true);
			//보내는사람 
			messageHelper.setFrom("dlrjsgmlv@gmail.com","가자");
			//받는사람
			messageHelper.setTo(new InternetAddress(member.getMember_id(),member.getMember_name(),"UTF-8"));
			
			
			
			DataSource dataSource = new FileDataSource("d:\\gogogo.jpg");
			messageHelper.addAttachment(MimeUtility.encodeText("다스.jpg","UTF-8","B"), dataSource);
			
			
			mailSender.send(message);
			
		} catch (MessagingException | UnsupportedEncodingException e) {
		
			
			e.printStackTrace();
		}
	
		
		
	}
	
}
