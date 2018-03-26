package com.bitcamp.open.member.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.open.member.Model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setIdx(rs.getInt("idx"));
		member.setMember_id(rs.getString("member_id"));
		member.setMember_name(rs.getString("member_name"));
		member.setPhoto(rs.getString("photo"));

		return member;
	}

	
	
	
}