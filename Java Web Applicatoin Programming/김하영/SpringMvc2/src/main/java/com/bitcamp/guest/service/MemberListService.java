package com.bitcamp.guest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.guest.dao.MemberDao;
import com.bitcamp.guest.model.Member;

public class MemberListService {
	@Autowired
	private MemberDao dao;
		
	public List<Member> listByService() {
		List<Member> list = dao.selectMemberBy();
		return list; 
	}
	
	public Member regMember(String member_id) {
		return dao.selectBy(member_id);
	}
	
	public int updateMember(Member member) {
		
		int resultCnt = dao.updateMember(member);
	
		return resultCnt;
	}
	
	public int deleteMember(String member_id) {
		
		int resultCnt = dao.deleteMember(member_id);
		return resultCnt;
	}
	
	
}
