package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberRegService {

	//MemberDao dao;

	// 프러퍼티 방식으로 의존 주입 . setter 메서드 이용
	/*public void setDao(MemberDao dao) {
		this.dao = dao;
	}*/
	
	
	//private MemberMyBatisDao dao;
	
	/*public void setDao(MemberMyBatisDao dao) {
		this.dao = dao;
	}
*/
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao; 
	
	@Autowired
	MultipartService service;

	/*@Autowired
	private SimpleRegistrationNotifier notifier;

	@Autowired
	private SimpleRegistrationNotifier2 notifier2;*/
	
	public int memberReg(Member member,  HttpServletRequest request) throws IllegalStateException, IOException {
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		
		service.multipart(member, request);
		
		System.out.println("실행전 : " + member.getIdx());
		
		// 업로드한 파일의 데이터를 Member에 등록

		// dao 요청 : 데이터 저장 요청		
		int resultCnt = dao.insertMember(member);
							
		System.out.println("실행후 : " + member.getIdx());
		
		// 메일 발송		
		// notifier.sendMail(member);
		
		//notifier2.sendMail(member);
		//notifier2.sendMailAttach(member);
		

		return resultCnt;
	}

}
