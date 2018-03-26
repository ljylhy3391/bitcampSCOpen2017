package com.bitcamp.guest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.guest.model.Member;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	// jdbcTemplate 를 사용할수 있도록 의존설정
	public MemberDao(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insertdao(Member member) {
		int resultCnt = 0;

		String sql = "insert into member(member_id,member_name,password,photo) values(?,?,?,?)";

		resultCnt = jdbcTemplate.update(sql, member.getMember_id(), member.getMember_name(), member.getPassword(),
				member.getPhoto());

		return resultCnt;
	}

	public Member selectBy(String member_id) {
		String sql = "select * from member where member_id=?";
		List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				// select 결과값을 member 객체에 저장하여 반환
				member.setIdx(rs.getInt("idx"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getDate("regdate"));
				member.setPhoto(rs.getString("photo"));

				return member;
			}

		}, member_id);

		// null이면 true 반환
		return list.isEmpty() ? null : list.get(0);
	}

	/*
	 * // null이면 true 반환 return list.isEmpty() ? null : list.get(0);
	 */

	//
	/*
	 * List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {
	 * 
	 * @Override public Member mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { Member member = new Member(); // select 결과값을 member 객체에 저장하여 반환
	 * member.setMember_name(rs.getString("member_name"));
	 * member.setPassword(rs.getString("password"));
	 * member.setPhoto(rs.getString("photo"));
	 * 
	 * return member; }
	 * 
	 * }, member_id);
	 */
	/*
	 * // null이면 true 반환 return list.isEmpty() ? null : list.get(0);
	 */

	public List<Member> selectMemberBy() {
		String sql = "select * from member";
		List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();

				member.setIdx(rs.getInt("idx"));
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setPhoto(rs.getString("photo"));

				return member;

			}

		});
		return list.isEmpty() ? null : list;

	}

	public int updateMember(Member member) {

		String sql = "update member set member_name =?,password =?,photo =?  where member_id =?";
		int resultCnt = jdbcTemplate.update(sql,member.getMember_name(),member.getPassword(),member.getPhoto(),member.getMember_id());
		
		// TODO Auto-generated method stub
		return resultCnt;
	}
	
	public int deleteMember(String member_id) {
		String sql="delete from member where member_id=?";
		int resultCnt=jdbcTemplate.update(sql,member_id);
		
		return resultCnt;
		
	}

}
