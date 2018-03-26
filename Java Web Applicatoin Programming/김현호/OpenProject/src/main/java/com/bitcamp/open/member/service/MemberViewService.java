package com.bitcamp.open.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.model.Member;

public class MemberViewService {
	
	@Autowired
	private MemberDao dao;

	public Member getMember(String id) {
		// TODO Auto-generated method stub
		Member list = dao.selectView(id);
		
		return list;
	}

}
