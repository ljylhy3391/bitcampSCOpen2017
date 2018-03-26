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

	@Autowired
	private MemberFileService service;

	public Member updateSelect(String member_id) {

		Member member;
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		member = dao.selectById(member_id);
		return member;
	}

	public int updateMemberList(Member member,HttpServletRequest request)throws IllegalStateException,IOException {
		
				
		
	
		service.memberPhotoUpload(member, request);
		
        dao = sqlSessionTemplate.getMapper(LoginDao.class);
		int resultCnt = dao.updateById(member);
		
		return resultCnt;
	}

}
