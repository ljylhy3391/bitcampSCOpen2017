package com.bit.A.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.A.member.dao.LoginDao;
import com.bit.A.member.model.Member;

public class MemberListService {
	
//	@Autowired
//	private MemberMyBatisDao dao;
//	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LoginDao dao;
	
	public List<Member> getMemberList() {
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
//		List<Member> list = dao.delectMembers();
		List<Member> list = dao.selectList();
		
		return list;
	}
	
	
}
