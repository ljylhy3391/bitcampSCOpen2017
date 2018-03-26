package com.bitcamp.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.mvc.dao.MemberDao2;
import com.bitcamp.mvc.model.Member;

@Service("MemberFindByIdService")
public class MemberFindByIdService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao2 dao;
	
	@Transactional
	public Member findById(Long id)
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		Member member = dao.selectById(id);
		if (member == null) {
			throw new MemberNotFoundException("회원 없음 : " + id);
		}
		return member;
	}
	
	// @Autowired
	// private MemberDao memberDao;
	//
	// public Member findById(Long id)
	// {
	// Member member = memberDao.selectById(id);
	// if (member == null) {
	// throw new MemberNotFoundException("회원 없음 : " + id);
	// }
	// return member;
	// }
}
