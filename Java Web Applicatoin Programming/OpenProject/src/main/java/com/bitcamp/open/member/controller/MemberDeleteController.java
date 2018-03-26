package com.bitcamp.open.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	private MemberDeleteService memberDeleteService;
	
	@RequestMapping("/member/memberDelete")
	public String memberDeleteForm(@RequestParam(value = "member_id") String id) {
		memberDeleteService.memberDelete(id);
		String view = "redirect:/member/list";
		return view;
	}

}
