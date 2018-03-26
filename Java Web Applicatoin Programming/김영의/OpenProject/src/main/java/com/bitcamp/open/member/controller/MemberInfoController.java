package com.bitcamp.open.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberInfoService;

@Controller
public class MemberInfoController {

	@Autowired
	private MemberInfoService memberInfoService;

	@RequestMapping("/member/memberInfo")
	public String memberInfo(@RequestParam(value = "member_id", defaultValue = "0") String id, Model model) {
		Member member = memberInfoService.memberInfo(id);
		model.addAttribute("member", member);
		return "member/mypage";
	}
}
