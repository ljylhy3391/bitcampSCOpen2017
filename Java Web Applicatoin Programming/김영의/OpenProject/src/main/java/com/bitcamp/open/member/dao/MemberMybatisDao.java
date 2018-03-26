package com.bitcamp.open.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.model.Member;

public class MemberMybatisDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 매퍼의 네임스페이스 지정
	private String ns = "com.bitcamp.open.mybatis.mapper.MemberMapper"; // 인스턴스 변수

	public int insertMember(Member member) {

		// String id = ".insertMember";
		// return sqlSessionTemplate.update(ns + id, member);
		return sqlSessionTemplate.update(ns + ".insertMember", member);
	}

	public Member selectById(String id) {
		return sqlSessionTemplate.selectOne(ns + ".selectById", id);
	}

	public List<Member> selectAll() {
		//List<Member> members = sqlSessionTemplate.selectList(ns + ".selectList");
		//return members;
		return sqlSessionTemplate.selectList(ns + ".selectList");
	}
}