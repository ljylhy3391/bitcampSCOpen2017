package com.bitcamp.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.mvc.dao.MemberDao2;
import com.bitcamp.mvc.model.LoginRequest;
import com.bitcamp.mvc.model.Member;

@Service("MemberLoginService")
public class MemberLoginService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao2 dao;

	@Transactional
	public Member login(LoginRequest req)
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		Member member = dao.selectByEmail(req.getEmail());
		if (member == null) {
			throw new MemberNotFoundException("회원 없음 : " + req.getEmail());
		}
		if (!member.checkPassword(req.getPassword())) {
			throw new IdPasswordNotMatchingException("비밀번호 다름");
		}
		return member;
	}
}

/* 
// mybatis 적용전

@Service("MemberLoginService")
public class MemberLoginService
{
	@Autowired
	private MemberDao memberDao;

	public Member login(LoginRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member == null) {
			throw new MemberNotFoundException("회원 없음 : " + req.getEmail());
		}
		if (!member.checkPassword(req.getPassword())) {
			throw new IdPasswordNotMatchingException("비밀번호 다름");
		}
		return member;
	}
}
*/