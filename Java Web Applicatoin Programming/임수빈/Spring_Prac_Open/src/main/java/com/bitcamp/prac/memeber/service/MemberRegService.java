package com.bitcamp.prac.memeber.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.bitcamp.prac.dao.MemberDao;
import com.bitcamp.prac.memeber.model.Member;

public class MemberRegService {
	
	MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public int memberReg(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		
		String uploadURI = "/uploadfile/memberPhoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);
		
		if(!member.getPhotofile().isEmpty()) {
			String fileName = member.getMemberId()+"_"+member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setMemberPhoto(fileName);
		}
		
		int resultCnt = dao.insertMember(member);
		
		return resultCnt;
	}

}
