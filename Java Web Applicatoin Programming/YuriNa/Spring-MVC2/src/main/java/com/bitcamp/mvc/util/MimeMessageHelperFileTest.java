package com.bitcamp.mvc.util;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bitcamp.mvc.model.Member;

@Service("MimeMessageHelperFileTest")
public class MimeMessageHelperFileTest implements SendMailService
{
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(Member member)
	{
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject("[공지] 회원 가입 안내");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("noreply@localhost.com", "로컬유리");
			messageHelper.setTo(new InternetAddress(member.getEmail(), member.getName(), "UTF-8"));
			
			DataSource dataSource = new FileDataSource("C:\\Users\\403room-23\\Desktop\\hi.doc");
			messageHelper.addAttachment(MimeUtility.encodeText("hi.doc", "UTF-8", "B"), dataSource);
			mailSender.send(message);
		}
		catch (MailException e) {
			e.printStackTrace();
			return;
		}
		catch (Throwable e) {
			e.printStackTrace();
			return;
		}
	}
} // MimeMessageHelper을 이용한 파일 첨부
