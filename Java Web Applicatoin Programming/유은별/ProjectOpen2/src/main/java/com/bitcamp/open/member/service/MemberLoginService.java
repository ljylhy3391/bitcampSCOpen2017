package com.bitcamp.open.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberLoginService {
	
	//@Autowired
	//1.MemberDao dao;
	//2.MemberMyBatisDao dao;
	
	//Dao인터페이스로 자동 맵퍼 생성을 위해 템플릿 클래스 이용
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private LoginDao dao; 
	
	
	public Member loginChk(String id, String pw) {
		
		//인터페이스를 사용할 수 있는 dao로 만듦
		//런타임시에(실행중) 맵퍼 생성을 위한 처리 
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		
		// Member 객체를 dao 통해서 받는다. 
		Member member = dao.selectById(id);
		System.out.println("svc : " + member);
		
		// 비밀번호 체크
		if(member != null && !member.matchPassword(pw)) {
			member = null;
		}
		
		return member;
	}

	public Member selectById(String id) {
		
		return dao.selectById(id);
	}
	
	
	

}





