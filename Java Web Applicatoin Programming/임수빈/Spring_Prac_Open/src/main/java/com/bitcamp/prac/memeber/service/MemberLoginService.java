package com.bitcamp.prac.memeber.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.prac.memeber.model.Member;
import com.bitcamp.prac.dao.MemberDao;

public class MemberLoginService {
	
	@Autowired
	MemberDao dao;
	
	public Member loginCheck(String id, String pw) {
		Member member = dao.selectById(id);
		System.out.println("svc: " +member);
		
		if(member != null && !member.matchPassword(pw)) {
			member = null;
		}
		return member;
	}
	
	public Member selectById(String id) {
		return dao.selectById(id);
	}

}
