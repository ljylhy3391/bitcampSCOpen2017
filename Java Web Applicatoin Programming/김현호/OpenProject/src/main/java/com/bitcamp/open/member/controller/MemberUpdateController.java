package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberUpdateService;

@Controller
@RequestMapping("/member/memberupdateForm")
public class MemberUpdateController {
	
	@Autowired
	private MemberUpdateService memberUpdateService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memberupdateForm(Model model,HttpServletRequest request) {
		String member_id = request.getParameter("member_id");
		Member member = memberUpdateService.selectById(member_id);
		model.addAttribute("member",member);
		return "/member/memberupdateForm";
		
     }
	@RequestMapping(method= RequestMethod.POST)
	public String memberupdate(Member member, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException{
		//서비스에 회원정보 수정 처리를 요청
		//0: 실패, 1: 성공
		//model에 저장
		
		System.out.println(member);
		
		int resultCnt = memberUpdateService.memberupdate(member, request);
		
		String msg = "수정 완료";
		
		if(resultCnt == 0) {
			msg = "수정처리 되지 않았습니다.";
		}
        model.addAttribute("msg", msg);
		
		
		return "member/memberupdate";
	}
	
	@ExceptionHandler(IOException.class)
	public String ex1(IOException e) {
		return "error/ex1";
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public String ex2(IllegalStateException e) {
		return "error/ex2";
	}
	
		
		
	
   }


