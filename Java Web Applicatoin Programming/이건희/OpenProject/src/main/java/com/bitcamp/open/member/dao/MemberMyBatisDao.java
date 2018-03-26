package com.bitcamp.open.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.Model.Member;

public class MemberMyBatisDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String ns = "com.bitcamp.open.mybatis.mapper.MemberMapper";
	
	
	public Member selectById(String user_id) {
		int resultCnt;
			String id = "selectById";
		
		return sqlSessionTemplate.selectOne(ns+id,user_id);
	}


	public int insertMember(Member member) {		
		return sqlSessionTemplate.update(ns+".insertMember", member);		
	}
	
	public List<Member> selectMembers(){
		
		List<Member> mebers =sqlSessionTemplate.selectList(ns+".selectList");
		return mebers;
	}

	

}
