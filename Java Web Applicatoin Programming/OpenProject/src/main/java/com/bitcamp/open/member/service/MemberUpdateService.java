package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberUpdateService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao;

	public void memberUpdate(Member member, HttpServletRequest request) throws IllegalStateException, IOException {

		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);
		if (!member.getPhotofile().isEmpty()) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id() + "_" + member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setMember_photo(fileName);
		}
		dao.updateMember(member);
		//return member;
	}
}
