package com.bitcamp.prac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.prac.memeber.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

		Member member = new Member();
		member.setIdx(rs.getInt("idx"));
		member.setMemberId(rs.getString("member_id"));
		member.setMemberName(rs.getString("member_name"));
		member.setMemberPw(rs.getString("password"));
		member.setRegdate(rs.getDate("regdate"));
		member.setMemberPhoto(rs.getString("photo"));		
		
		return member;
	}

}
