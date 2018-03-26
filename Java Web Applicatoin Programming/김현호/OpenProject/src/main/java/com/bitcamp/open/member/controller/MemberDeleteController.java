package com.bitcamp.open.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bitcamp.open.member.service.MemberDeleteService;

@Controller
@RequestMapping("/member/memberDelete")
public class MemberDeleteController {
	
	
	//자동 주입
	@Autowired
	private MemberDeleteService memberDeleteService;
	
	
	//회원 삭제 처리
	@RequestMapping(method = RequestMethod.GET)
	public String memberDelete(HttpServletRequest request){
		//request 객체로 meber_id 파라미터값을 받는다.
		String member_id = request.getParameter("member_id");
		System.out.println(member_id);
		memberDeleteService.memberDelete(member_id);
		 //model.addAttribute("member",member);

		
		return "redirect:memberList";
		
		
     }		
 }
		



