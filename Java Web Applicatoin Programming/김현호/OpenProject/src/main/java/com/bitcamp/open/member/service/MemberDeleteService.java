package com.bitcamp.open.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.MemberMyBatisDao;
import com.bitcamp.open.member.model.Member;

public class MemberDeleteService {

	@Autowired
	private MemberMyBatisDao dao;

	public int memberDelete(String member_id) {
		System.out.println("확인");
		System.out.println(member_id);
		int resultCnt = dao.memberDelete(member_id);
		return resultCnt;

	}
}
