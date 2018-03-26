package com.bitcamp.mvc.util;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bitcamp.mvc.model.Member;

@Service("MimeMessageInlineTest")
public class MimeMessageInlineTest implements SendMailService
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
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다."
					+ "<img src=\"cid:logo.png\">";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("noreply@localhost.com", "로컬");
			messageHelper.setTo(new InternetAddress(member.getEmail(), member.getName(), "UTF-8"));
			
			DataSource dataSource = new FileDataSource("C:\\Users\\403room-23\\Desktop\\ddd.png");
			messageHelper.addInline("logo.png", dataSource);
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
}
