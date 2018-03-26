package com.bitcamp.open.member.dao;

import java.util.List;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.model.Member2;

public interface LoginDao {

	public Member selectById(String id);

	public int insertMember(Member member);

	public List<Member> selectList();
	
	public List<Member2> selectListXML();

	public void updateMember(Member member);

	public void deleteMember(String id);
	
}
