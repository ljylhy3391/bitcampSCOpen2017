package com.bitcamp.open.member.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "idx", "member_name", "member_id", "member_date" })
public class Member2 {
	int idx;
	private String member_name;
	private String member_id;
	private Date member_date;

	public Member2() {
	}

	public Member2(int idx, String member_name, String member_id, Date member_date) {
		super();
		this.idx = idx;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_date = member_date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Date getMember_date() {
		return member_date;
	}

	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}

}
