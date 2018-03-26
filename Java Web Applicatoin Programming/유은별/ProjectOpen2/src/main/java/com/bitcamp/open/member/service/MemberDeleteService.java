package com.bitcamp.open.member.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.bitcamp.open.member.dao.LoginDao;

public class MemberDeleteService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao;
	
	public int deleteMemberList(String member_id) {
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		int resultCnt = dao.deletById(member_id);
		
		
		return resultCnt;
				
	}
}
