package com.bitcamp.prac.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.prac.memeber.model.Member;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insertMember(Member member) {
		
		String sql = "insert into member (member_id, member_name, password, photo) values(?,?,?,?)";
		int resultCnt = jdbcTemplate.update(sql,
				member.getMemberId(),
				member.getMemberName(),
				member.getMemberPw(),
				member.getMemberPhoto());				
		
		return resultCnt;
	}
	
	public Member selectById(String id) {
		String sql = "select * from member where member_id=?";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(),id);		
		return result.isEmpty()? null:result.get(0);
	}
	
	public List<Member> selectMembers(){
		String sql = "select * from member";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper());
		return result;
	}

}
