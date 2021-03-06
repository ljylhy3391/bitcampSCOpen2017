package com.bitcamp.open.member.dao;

import java.util.List;

import com.bitcamp.open.member.model.Member;

public interface LoginDao {
	
	public Member selectById(String id);
	public int insertMember(Member member);
	public List<Member> selectList();
	public Member memberView(String id);
	public int memberUpdate(Member member);
	//public int selectCount();

}
