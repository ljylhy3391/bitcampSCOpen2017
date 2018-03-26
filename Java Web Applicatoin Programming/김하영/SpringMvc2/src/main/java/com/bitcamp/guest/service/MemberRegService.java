package com.bitcamp.guest.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.bitcamp.guest.dao.MemberDao;
import com.bitcamp.guest.model.Member;

public class MemberRegService {
	
	//dao 객체 생성할것 
	@Autowired
	MemberDao dao;
	
	
	public int insertoService(Member member,HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		
		String uploadURI = "/uploadfile/memberphoto";//url경로지정
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
			// request.getSession().getServletContext() 절대경로를 구함 
			//getRealPath(uploadURI)경로 추가 
		System.out.println(dir);	
		System.out.println(dir);
		System.out.println(member.getMember_id());
		System.out.println("-------------");
		System.out.println(member.getFilename());

		if(!member.getFilename().isEmpty()) {//getOriginalFilename 파일의 이름을 가져옴 
			String filename =  member.getMember_id()+"_"+member.getFilename().getOriginalFilename();
			member.getFilename().transferTo(new File(dir,filename));
			System.out.println(member.getFilename().getOriginalFilename());
			//transferTo은 MultipartFile의 메서드 인데 getFilename이 MultipartFile 의 타입이기때문에 사용 
			//new File(filename,dir)저장할 파일의 이름 경로 를 지정
			//transferTo물리적인 저장 
			member.setPhoto(filename);
			
		}
		int resultCnt = dao.insertdao(member);
		
		
		return resultCnt;
	}
}
