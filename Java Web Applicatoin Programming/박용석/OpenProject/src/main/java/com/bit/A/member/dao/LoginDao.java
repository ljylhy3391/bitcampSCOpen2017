package com.bit.A.member.dao;

import java.util.List;

import com.bit.A.member.model.Member;

public interface LoginDao {
	
	public Member selectById(String id);
	public int insertMember(Member member);
	public List<Member> selectList();
	//public int selectCount();
	

}
