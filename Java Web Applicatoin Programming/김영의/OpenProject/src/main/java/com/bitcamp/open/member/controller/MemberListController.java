package com.bitcamp.open.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService memberListService;

	@RequestMapping("/member/list")
	public String list(Model model) {
		List<Member> memberlist = memberListService.listview();
		model.addAttribute("memberlist", memberlist);
		/*
		 * if (members == null) { return "member/listFail"; }
		 */
		return "member/list";
	}
}
