package com.bitcamp.open.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberViewService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LoginDao dao; 
	
	public Member viewMemberList(String id){
		
		Member member;
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		member = dao.viewInfo(id);
		
		return member;
	}

	
	

}
