package com.bitcamp.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.mvc.dao.MemberDao2;
import com.bitcamp.mvc.model.Member;
import com.bitcamp.mvc.model.RegisterRequest;

@Service("MemberRegisterService")
public class MemberRegisterService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao2 dao;
	
	@Transactional
	public Member register(RegisterRequest req)
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("이메일 중복 : " + req.getEmail());
		}
		member = req.toMember();
		dao.insertMember(member);
		
		return member;
	}
	
	// @Autowired
	// private MemberDao memberDao;
	//
	// public void register(RegisterRequest req) {
	// Member member = memberDao.selectByEmail(req.getEmail());
	// if (member != null) {
	// throw new AlreadyExistingMemberException("이메일 중복 : " + req.getEmail());
	// }
	// memberDao.insert(req.toMember());
	// }
}
