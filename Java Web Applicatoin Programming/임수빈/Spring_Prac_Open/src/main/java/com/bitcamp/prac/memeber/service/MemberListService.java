package com.bitcamp.prac.memeber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.prac.dao.MemberDao;
import com.bitcamp.prac.memeber.model.Member;

public class MemberListService {
	
	@Autowired
	private MemberDao dao;
	
	public List<Member> getMemberList(){
		
		List<Member> list = dao.selectMembers();
		return list;
	}

}
