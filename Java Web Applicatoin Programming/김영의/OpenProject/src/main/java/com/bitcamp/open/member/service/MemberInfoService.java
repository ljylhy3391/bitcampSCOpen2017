package com.bitcamp.open.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberInfoService {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao;
	
	public Member memberInfo(String id) {
		dao = sqlSessionTemplate.getMapper(LoginDao.class);

		Member member = dao.selectById(id);
		return member;
	}
}
