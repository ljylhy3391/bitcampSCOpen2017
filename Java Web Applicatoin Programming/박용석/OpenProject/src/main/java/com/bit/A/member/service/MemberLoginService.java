package com.bit.A.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.A.member.dao.LoginDao;
import com.bit.A.member.model.Member;

public class MemberLoginService {
	
//	@Autowired
//	MemberMyBatisDao dao;
//	MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// Dao 인터페이스를 자동으로 자동 메퍼 생성을 위해 템플릿 클래스 이용
	
	private LoginDao dao;
	
	public Member loginChk(String id, String pw) {
		// Member 객체를 dao 통해서 받는다.
		
		// 런타임시에(실행중) 메퍼 생성을 위한 처리
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		Member member = dao.selectById(id);
		System.out.println("svc : " + member);
		
		// 비밀번호 체크
		if(member != null && !member.matchPassword(pw)) {
		
			member = null;
		}
		
		
		return member;
		
	}

	public Member selectById(String id) {

		return dao.selectById(id);
	}
	

}
