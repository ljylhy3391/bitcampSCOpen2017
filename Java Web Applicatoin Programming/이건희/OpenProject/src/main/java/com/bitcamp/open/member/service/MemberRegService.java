package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.dao.MemberMyBatisDao;

public class MemberRegService {

	/*
	 * private MemberDao dao;
	 * 
	 * // 프러퍼티 방식으로 의존 주입 public void setDao(MemberDao dao) { this.dao = dao; }
	 */
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired//메일 서비스 
	SimpleRegistrationNotifier registrationNotifier;
	
	@Autowired//메일 서비스 
	SimpleRegistrationNotifier2 registrationNotifier2;
	
	
	@Autowired //메일샌더 
	private MailSender mailSender;
/*	private MemberMyBatisDao dao;

	public void setDao(MemberMyBatisDao dao) {
		this.dao = dao;
	}
	*/
	private LoginDao dao;

	public int memberReg(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		// 파일 업로더 처리
		// 업로드 폴더 시스템 물리적 경로 찾기
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);

		// 파일저장 //증명사진.jpg
		// 회원의 사진은 하나만 존재한다 중복된 이름의 파일 으 들어올경우 덮어 씌워지기 때문에 id값을 fileName로 넣어줌
		// 파일 이름 생성 : 회원아이디_ 원본 파일 이름
		if (!member.getPhotofile().isEmpty()) {
			// null이 아니면
			// 새로운 파일이름 생성 - > 파일 저장 -> DB에 저장할 파일이름 set
			System.out.println(member.getMember_id());
			System.out.println("-------------");
			System.out.println(member.getPhotofile());
			String fileName = member.getMember_id() + "_" + member.getPhotofile().getOriginalFilename();// id값을
																										// fileName으로
																										// 줄것임
			System.out.println(member.getPhotofile().getOriginalFilename());
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setPhoto(fileName);// 새롭게 만들어진 photoName을 setPhoto로

		
		}
		
			
		
		//메일 보내기 설정
		
		// 업로드한 파일의 데이터 Meber member에 등록

		// dao요청 : 데이터 저장 요청
		int resultCnt = dao.insertMember(member);
		registrationNotifier2.sendMail(member);
		registrationNotifier2.sendMailAttach(member);
		return resultCnt;
	}

	
	
		
	
}
