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
public class memberViewController {

	@Autowired
	private MemberViewService service;

	@RequestMapping("/member/memberView")
	public String memberView(@RequestParam("member_id")String member_id,
			Model model ) {
		
		Member member = service.viewMemberList(member_id);
		
		model.addAttribute("member", member);
		
		
		return "member/memberView";

	}

}
