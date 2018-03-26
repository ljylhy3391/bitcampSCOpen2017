package com.bitcamp.open.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.open.member.model.Member;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	// 생성자 방식으로 의존 설정.
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insertMember(Member member) {

		String sql = "insert into member(member_name, member_id, member_pw, member_photo) values(?,?,?,?)";

		int resultCnt = jdbcTemplate.update(sql, member.getMember_name(), member.getMember_id(), member.getMember_pw(),
				member.getMember_photo());

		return resultCnt;
	}

	public Member selectById(String id) {
		String sql = "select * from member where member_id=?";

		List<Member> result = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_date(rs.getDate("member_date"));
				member.setMember_photo(rs.getString("member_photo"));
				return member;
			}

		}, id);

		return result.isEmpty() ? null : result.get(0);
	}

	public List<Member> selectAll() {

		String sql = "select * from member";
		List<Member> results = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_date(rs.getDate("member_date"));
				member.setMember_photo(rs.getString("member_photo"));
				return member;
			}

		});

		return results.isEmpty() ? null : results;
	}

}
