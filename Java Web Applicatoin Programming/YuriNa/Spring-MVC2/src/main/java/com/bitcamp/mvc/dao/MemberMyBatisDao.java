package com.bitcamp.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.mvc.model.Member;

public class MemberMyBatisDao
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insert(Member member)
	{
		String str = "com.bitcamp.mvc.mapper.MemberMapper.insertMember";
		int num = sqlSessionTemplate.update(str, member);
		System.out.println(num);
	}

	public Member selectByEmail(String email)
	{
		String str = "com.bitcamp.mvc.mapper.MemberMapper.selectByEmail";
		return (Member) sqlSessionTemplate.selectOne(str, email);
	}
}
