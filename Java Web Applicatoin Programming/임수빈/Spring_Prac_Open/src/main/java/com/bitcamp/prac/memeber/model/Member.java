package com.bitcamp.prac.memeber.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private int idx;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhoto;
	private Date regdate;
	private MultipartFile photofile;
	
	public Member() {	
	}
	
	public Member(int idx, String memberId, String memberPw, String memberName, String memberPhoto, Date regdate, MultipartFile photofile) {
		super();
		this.idx = idx;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhoto = memberPhoto;
		this.regdate = regdate;
		this.photofile = photofile;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
		

	public MultipartFile getPhotofile() {
		return photofile;
	}

	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhoto=" + memberPhoto + ", regdate=" + regdate + ", photofile=" + photofile + "]";
	}

	public boolean matchPassword(String pw) {
		return memberPw.equals(pw);
	}

}
