package com.bit.A.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.A.member.model.Member;

public class MemberMyBatisDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 메퍼의 네임스페이스 지정
	private String ns = "com.bit.A.mybatis.mapper.MemberMapper";

	public int insertMember(Member member) {
		// String id = ".insertMemeber";
		return sqlSessionTemplate.update(ns+".insertMember", member);		
	}
	
	
	public Member selectById(String id) {
		return sqlSessionTemplate.selectOne(ns+"slectById", id);
		
	}
	
	public List<Member> selectMembers(){
//		List<Member> members = sqlSessionTemplate.selectList(ns+".selectList") ;	
		return sqlSessionTemplate.selectList(ns+".selectList");
		
	}
	
}
