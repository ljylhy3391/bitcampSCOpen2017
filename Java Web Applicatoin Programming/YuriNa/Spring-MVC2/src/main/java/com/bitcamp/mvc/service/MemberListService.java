package com.bitcamp.mvc.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.mvc.dao.MemberDao2;
import com.bitcamp.mvc.model.Member;

@Service("MemberListService")
public class MemberListService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDao2 dao;
	
	@Transactional
	public List<Member> selectAll()
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		return dao.selectList();
	}
	
	@Transactional
	public int count()
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		return dao.selectCount();
	}
	
	// @Autowired
	// private MemberDao memberDao;
	//
	// public List<Member> selectAll()
	// {
	// return memberDao.selectAll();
	// }
	//
	// public int count()
	// {
	// return memberDao.count();
	// }
}
