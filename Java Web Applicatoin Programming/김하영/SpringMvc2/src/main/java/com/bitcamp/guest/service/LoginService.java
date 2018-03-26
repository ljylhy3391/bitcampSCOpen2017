package com.bitcamp.guest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.guest.dao.MemberDao;
import com.bitcamp.guest.model.Member;

public class LoginService {

	//의존주입 
	@Autowired
	MemberDao dao;
	
	public Member selectByIdService(String member_id,String password) {
		Member member = dao.selectBy(member_id);
		if(member!=null) {
			String pw = member.getPassword();
			if(pw.equals(password)) {
				//비밀번호가 같으면 
				//v패스
			}else {
				//다르면 
				member = null;
				//null을 주입
			}
		}
	
		
		return member;
	}
	
}
