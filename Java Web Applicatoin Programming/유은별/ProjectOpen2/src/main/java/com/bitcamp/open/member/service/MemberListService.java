package com.bitcamp.open.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.dao.MemberMyBatisDao;
import com.bitcamp.open.member.model.Member;

public class MemberListService {
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LoginDao dao; 
	
	
	
	//@Autowired
	//private MemberMyBatisDao dao;
	//private MemberDao dao;
	
	public List<Member> getMemberList(){
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		//List<Member> list = dao.selectMembers();   MemberMyBaitsDao설정에서 이름이고
		
		List<Member> list = dao.selectList(); // LoginDao확인  
		
		
		
		return list;
		
		
		
	}
	

}
