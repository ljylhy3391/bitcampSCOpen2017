package com.bitcamp.open.member.controller;

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
	private MemberViewService memberViewService;

	@RequestMapping("/member/memberView")
	public String memberView(@RequestParam(value="member_id") String id, Model model) {

		Member members = memberViewService.MemberView(id);
		
		System.out.println(members);

		model.addAttribute("members", members);

		return "member/memberView";
	}

}
