package com.bitcamp.open.member.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.open.member.model.Member;

public class SimpleRegistrationNotifier2 {

	@Autowired
	private JavaMailSender mailSender;// 메일 발송 기능을 위한 MailSender 인터페이스 제공

	public void sendMail(Member member) {
		// MailSender 인터페이스를 상속받은 JavaMailSender는 Java Mail API의 MimeMessage를 이용해서 메일을
		// JavaMailSender 인터페이스는 MimeMessage 객체를 생성해주는 createMimeMessage() 메서드를 제공
		// 발송하는 추가적인 기능 정의
		// 보내는 정보를 MimeMessage 객체에 담는다.
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// 제목설정
			message.setSubject("회원가입안내");
			// 내용설정(html)
			String htmlMsg = "<strong>안녕하세요" + member.getMember_name() + "</strong>, 반갑습니다.";
			message.setText(htmlMsg, "utf-8", "html");
			// 보내는 메일 주소
			message.setFrom(new InternetAddress("duddml42@gamil.com"));
			// 받는 메일 주소
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
			// MimeMessage를 이용하여 파일 첨부를 할 수 있지만 복잡하므로, 스프링이 제공하는 MimeMessageHelper 클래스를 사용
			// 메일에 파일 첨부를 위해서 MimeMessageHelper 클래스 이용, 생성자 매개변수(메시지, 파일첨부여부,인코딩)
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			// 제목설정
			helper.setSubject("회원가입");
			// 내용 설정
			String htmlContent = "<strong>안녕하세요!" + member.getMember_name() + "</strong> 반갑습니다.";
			helper.setText(htmlContent, true);
			// 보내는 사람 설정
			helper.setFrom("duddml42@gmail.com", "여신");
			// 받는 사람 설정
			helper.setTo(new InternetAddress(member.getMember_id(), member.getMember_name(), "utf-8"));

			// 첨부파일 설정
			DataSource dataSource = new FileDataSource("d:\\무민_여.PNG");
			// MimeUtilty 클래스는 Java Mail API에서 제공하는 클래스, ASCII 이외의 문자로 구성된 문장을 알맞게 인코딩
			helper.addAttachment(MimeUtility.encodeText("무민.PNG", "utf-8", "B"), dataSource);

			mailSender.send(message);

		} catch (MessagingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
