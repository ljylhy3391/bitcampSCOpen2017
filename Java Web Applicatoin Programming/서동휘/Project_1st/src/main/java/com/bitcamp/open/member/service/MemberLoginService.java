package com.bitcamp.open.member.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.MemberMyBatisDao;
import com.bitcamp.open.member.model.Member;

public class MemberLoginService {
	
	@Autowired
	private MemberMyBatisDao dao;
	
	
	
	public Member loginChk(String id, String pw) {
		// Member 객체를 dao 통해서 받는다. 
		
		// 런타임시에(실행중) 메퍼 생성을 위한 처리 
	
		
		
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





