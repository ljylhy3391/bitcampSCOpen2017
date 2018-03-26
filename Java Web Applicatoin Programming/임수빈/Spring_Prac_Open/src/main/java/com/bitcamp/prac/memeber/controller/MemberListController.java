package com.bitcamp.prac.memeber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.prac.memeber.model.Member;
import com.bitcamp.prac.memeber.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService service;
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model) {
		
		List<Member> members = service.getMemberList();
		System.out.println(members.get(0).getMemberPhoto());
		model.addAttribute("members", members);
		
		return "member/memberList";
	}
}
