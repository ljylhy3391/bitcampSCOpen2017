package com.bitcamp.guest.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {

	private int idx;
	private String member_id;
	private String member_name;
	private String password;
	private Date regdate;
	private String photo;
	private MultipartFile filename;
	
	
	
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int idx, String member_id, String member_name, String password, Date regdate, String photo) {
		super();
		this.idx = idx;
		this.member_id = member_id;
		this.member_name = member_name;
		this.password = password;
		this.regdate = regdate;
		this.photo = photo;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", member_id=" + member_id + ", member_name=" + member_name + ", password="
				+ password + ", regdate=" + regdate + ", photo=" + photo + ", filename=" + filename + "]";
	}
	
	
}
