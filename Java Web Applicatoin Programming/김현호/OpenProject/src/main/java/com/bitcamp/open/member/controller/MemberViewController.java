package com.bitcamp.open.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberViewService;

@Controller
public class MemberViewController {
	
	@Autowired
	private MemberViewService service;

	@RequestMapping("/member/memberview")
	public String memberList(@RequestParam(value ="member_id") String id,Model model) {
		
		Member member = service.getMember(id);	
		
		model.addAttribute("member", member);	
		
		return "member/memberview";
	}
	
	
	
	


	
	
}


