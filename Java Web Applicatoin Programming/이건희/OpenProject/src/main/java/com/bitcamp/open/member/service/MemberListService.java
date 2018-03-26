package com.bitcamp.open.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.Model.MemberMessage;
import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.dao.MemberMyBatisDao;

public class MemberListService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	LoginDao dao;
	
	@Autowired
	private MemberDao dao2;
	/*@Autowired
	private MemberMyBatisDao dao;
	*/
	public List<Member> getMemberList(){
		dao = sqlSessionTemplate.getMapper(LoginDao.class);

		List<Member> list = dao.selectList();
		
		return list;		
		
	}

	
	//xml select 
	
	public List<MemberMessage> xmlList(){
		
		List<MemberMessage> list = dao2.xmllist();
	System.out.println(list);
		return	list;
	}
	
	//리스트 개인정보 표기 
	
	public Member selectIdx(String idx) {
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		Member member = dao.selectIdx(idx);
		
		return member;
	}
	//리스트에서 
	//회원 삭제 
	
	public int delete(String idx) {
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		System.out.println("확인1");
		System.out.println(idx);
		int resultCnt = dao.deleteIdx(idx);
		
		return resultCnt;
		
		
	}
	

}
