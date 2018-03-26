package com.bitcamp.mvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.bitcamp.mvc.model.Member;

@Service("SimpleRegistrationNotifier")
public class SimpleRegistrationNotifier implements SendMailService
{
	@Autowired
	private MailSender mailSender;

	// @Autowired
	// private AES256Util aes256Util;

	@Override
	public void sendMail(Member member)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입을 축하합니다.");
		message.setFrom("isincorp@gmail.com");
		message.setText("회원 가입을 환영합니다.");
		message.setTo(member.getEmail());
		// message.setTo(aes256Util.aesEncode(String.valueOf(member.getId())));
		try {
			mailSender.send(message);
		}
		catch (MailException ex) {
			ex.printStackTrace();
		}
	}

	public void sendMail(String memberemail)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입 안내");
		message.setFrom("isisncorp@gmail.com");
		message.setText("회원 가입을 환영합니다.");
		message.setTo(memberemail);
		try {
			mailSender.send(message);
		}
		catch (MailException ex) {
			ex.printStackTrace();
		}

	}
}