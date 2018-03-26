package com.bitcamp.open.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.model.Member2;

public class MemberListService {
	// @Autowired
	// private MemberMybatisDao dao;
	// private MemberDao dao;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LoginDao dao;

	public List<Member> listview() {

		dao = sqlSessionTemplate.getMapper(LoginDao.class);

		// 자바의 컬렉션 : 객체 저장,List의 경우 저장 순서를 가진다, for문을 이용해서 전체 참조
		List<Member> memberlist = dao.selectList();
		return memberlist;
	}

	public List<Member2> xmlList() {

		dao = sqlSessionTemplate.getMapper(LoginDao.class);

		// 자바의 컬렉션 : 객체 저장,List의 경우 저장 순서를 가진다, for문을 이용해서 전체 참조
		List<Member2> memberlist = dao.selectListXML();
		return memberlist;
	}

}
