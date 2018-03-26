package com.bitcamp.open.member.dao;

import java.util.List;

import com.bitcamp.open.member.Model.Member;

public interface LoginDao {

	public Member selectById(String id);
	
	public int insertMember(Member member);
	
	public List<Member> selectList();

	public Member selectIdx(String idx);

	public int updateIdx(Member member);
	
	public int deleteIdx(String idx);
}
