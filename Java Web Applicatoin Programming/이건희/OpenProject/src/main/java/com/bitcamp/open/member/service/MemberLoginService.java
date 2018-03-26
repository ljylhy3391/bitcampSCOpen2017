package com.bitcamp.open.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.dao.MemberMyBatisDao;

public class MemberLoginService {
// 동을한 type를 찾아 주입
	//@Autowired
	//MemberDao dao; // 의존주입
	//private MemberMyBatisDao dao;
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//dao인터페이로 자동메퍼 생성을 위해 템플릿 클래스 이용
	
	@Autowired
	private SimpleRegistrationNotifier simpleRegistrationNotifier;
	
	private LoginDao dao;
	

	public Member loginChk(String id, String pw) {
		// 로그인 체크 dao 호출받아
		// Meber 객체를 Dao를 통해서 받는다
		
		//런타임시에(실행중) 매퍼 생성을 위한 처리 
		dao = sessionTemplate.getMapper(LoginDao.class);
		//인터페이스를 사용할수 있는 dao 형태로 만듬 
		
		Member member = dao.selectById(id);
		// 비밀번호 체크 // member안에 비밀번호 체크 메서드
		System.out.println("meber 객체는" + member);
		if (member != null && !member.matchPassword(pw)) {
			// member == null이 아니여야 확인이 가능함

			member = null;
		}
		
		// member 이 넘어가면 Controller에서 null 갑 체킇
		return member;
	}

	public Member selectById(String id) {

		return dao.selectById(id);
	}

}
