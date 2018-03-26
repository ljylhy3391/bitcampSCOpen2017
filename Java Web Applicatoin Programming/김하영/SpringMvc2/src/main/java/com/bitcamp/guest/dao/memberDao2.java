package com.bitcamp.guest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.guest.model.Member;

public interface memberDao2 {

	// jdbcTemplate 를 사용할수 있도록 의존설정
	public int insertdao(Member member) ;
	/*public Member selectBy(String member_id); 

	public List<Member> selectMemberBy();

	public int updateMember(Member member) ;
	public int deleteMember(String member_id) ;*/
}
