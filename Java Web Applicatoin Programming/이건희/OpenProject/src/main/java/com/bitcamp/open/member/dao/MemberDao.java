package com.bitcamp.open.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.Model.MemberMessage;
import com.bitcamp.open.member.service.MemberRowMapper;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	// jdbcTemplate 를 사용할수 있도록 의존설정
	public MemberDao(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insertMember(Member member) {
			
		String sql = "insert into member (member_id, member_name, password, photo) values(? , ? , ?, ?)";
		// update 반환값은 int (0///1)
		int ResultCnt = jdbcTemplate.update(sql, member.getMember_id(), member.getMember_name(), member.getPassword(),
				member.getPhoto());

		return ResultCnt;
	}

	public Member selectById(String id) {

		String sql = "select * from member where member_id = ?";
		// select 값을 받아야하기 때문에 resultSet 와 비슷한 RowMaper를 사용 익명클래스 형태로 사용

		List<Member> result = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getDate("regdate"));
				member.setPhoto(rs.getString("photo"));

				return member;
			}
		}, id);

		// null 이면 true반환
		return result.isEmpty() ? null : result.get(0);
	}

	public List<Member> selectMembers() {

		String sql = "select * from member";
		// select 값을 받아야하기 때문에 resultSet 와 비슷한 RowMaper를 사용 익명클래스 형태로 사용

		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper());

		// null 이면 true반환
		return result.isEmpty() ? null : result;

	}
	
	public List<MemberMessage> xmllist() {

		String sql = "select * from member";
		// select 값을 받아야하기 때문에 resultSet 와 비슷한 RowMaper를 사용 익명클래스 형태로 사용

		List<MemberMessage> result = jdbcTemplate.query(sql, new RowMapper<MemberMessage>() {

			@Override
			public MemberMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberMessage member = new MemberMessage();
				member.setIdx(rs.getInt("idx"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setRegdate(rs.getDate("regdate"));

				return member;
			}
		});

		// null 이면 true반환
		return result.isEmpty() ? null : result;
	}
	
}
