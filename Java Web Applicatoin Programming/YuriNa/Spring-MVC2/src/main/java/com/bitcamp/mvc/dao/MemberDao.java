package com.bitcamp.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.mvc.model.Member;
import com.bitcamp.mvc.service.MemberRowMapper;

@Repository("MemberDao")
public class MemberDao
{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER", new MemberRowMapper());
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM MEMBER", Integer.class);
		return count;
	}
	
	public Member selectById(Long id)
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE ID = ?", new MemberRowMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}

	public Member selectByEmail(String email)
	{
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE EMAIL = ?", new MemberRowMapper(), email);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(final Member member) // 생명주기가 다르기 때문에 final로 지정
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator()
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE, PHOTO) VALUES (?, ?, ?, ?, ?)",
						new String[] { "ID" });
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				pstmt.setString(5, member.getPhoto());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
}
