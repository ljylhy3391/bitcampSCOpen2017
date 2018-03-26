package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.dao.MemberMybatisDao;
import com.bitcamp.open.member.model.Member;

public class MemberRegService {
	/*
	 * MemberDao dao;
	 * 
	 * // 프로퍼티 방식으로 의존 주입.setter메서드 이용 public void setDao(MemberDao dao) { this.dao=
	 * dao; }
	 */

	/*
	 * private MemberMybatisDao dao;
	 * 
	 * public void setDao(MemberMybatisDao dao) { this.dao= dao; }
	 */

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao;
	
	@Autowired
	//private SimpleRegistrationNotifier notifier;
	private SimpleRegistrationNotifier2 notifier2;

	public int memberReg(Member member, HttpServletRequest request) throws IllegalStateException, IOException {

		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		// 파일 업로드 처리
		// 업로드 폴더 시스템 물리적 경로 찾기
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);

		// 파일 저장 : 증명사진.jpg
		// 회원의 사진은 하나만 존재한다.
		// 파일 이름 생성 : 회원아이디_원본파일이름
		if (!member.getPhotofile().isEmpty()) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id() + "_" + member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setMember_photo(fileName);
		}
		System.out.println("실행 전 : " + member.getIdx());

		// 업로드한 파일의 데이터를 Member에 등록

		// dao 요청 : 데이터 저장 요청
		int resultCnt = dao.insertMember(member);
		System.out.println("실행 후 : " + member.getIdx());
		
		//메일 발송
		//notifier.sendMail(member);
		//notifier2.sendMail(member);
		notifier2.sendMailAttach(member);
		
		return resultCnt;

	}

}
