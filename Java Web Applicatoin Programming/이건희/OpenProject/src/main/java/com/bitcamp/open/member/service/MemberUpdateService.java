package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.dao.LoginDao;

public class MemberUpdateService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	LoginDao dao;

	public Member UpdateSelect(String idx){
		Member member;
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		member = dao.selectIdx(idx);
		
		return member;
	}
	
	public int Update(Member member,HttpServletRequest request) throws IllegalStateException, IOException {
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
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
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		int resultCnt= dao.updateIdx(member);
		
		return  resultCnt;
	}
}
