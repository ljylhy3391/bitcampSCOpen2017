package com.bitcamp.open.member.dao;

import java.util.List;

import com.bitcamp.open.member.model.Member;

public interface LoginDao {
	
	public Member selectById(String id);
	public int insertMember(Member member);
	public List<Member> selectList();         
	//보기
	public Member viewInfo(String id);
	//수정
	public int updateById(Member member);
	//삭제
	public int deletById(String id);
	
	//찾아 들어가야 하니까 LoginDao.xml에서  id와 이름 맞춰준다

	//public int selectCount();

}
