package com.bitcamp.mvc.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.mvc.dao.MemberDao2;
import com.bitcamp.mvc.model.Member;
import com.bitcamp.mvc.model.UpdateRequest;

@Service("MemberUpdateService")
public class MemberUpdateService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private MemberDao2 dao;

	@Transactional
	public void update(UpdateRequest req)
	{
		dao = sqlSessionTemplate.getMapper(MemberDao2.class);
		Member member = dao.selectById(req.getId());
		if (member == null) {
			throw new MemberNotFoundException("회원 없음 : " + req.getId());
		}
		dao.updateMember(req.toMember());
	}
}
