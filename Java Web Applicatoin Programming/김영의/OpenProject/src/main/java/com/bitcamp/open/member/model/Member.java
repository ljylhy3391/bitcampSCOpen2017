package com.bitcamp.open.member.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	int idx;
	private String member_name;
	private String member_id;
	private String member_pw;
	private Date member_date;
	private MultipartFile photofile;
	private String member_photo;

	public Member() {
	}

	public Member(int idx, String member_name, String member_id, String member_pw, Date member_date,
			MultipartFile photofile, String member_photo) {
		super();
		this.idx = idx;
		this.member_name = member_name;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_date = member_date;
		this.photofile = photofile;
		this.member_photo = member_photo;
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

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public Date getMember_date() {
		return member_date;
	}

	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}

	public MultipartFile getPhotofile() {
		return photofile;
	}

	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}

	public String getMember_photo() {
		return member_photo;
	}

	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}

	public boolean matchPassword(String pw) {
		return member_pw.equals(pw);

	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", member_name=" + member_name + ", member_id=" + member_id + ", member_pw="
				+ member_pw + ", member_date=" + member_date + ", photofile=" + photofile + ", member_photo="
				+ member_photo + "]";
	}

}
