package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberInfoService;
import com.bitcamp.open.member.service.MemberUpdateService;

@Controller
@RequestMapping("/member/memberUpdate")
public class MemberUpdateController {

	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberUpdateService memberUpdateService;

	@RequestMapping(method = RequestMethod.GET)
	public String memberUpdateForm(@RequestParam(value = "member_id", defaultValue = "0") String id, Model model) {
		Member member = memberInfoService.memberInfo(id);
		model.addAttribute("member", member);
		return "member/memberUpdateForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String memberUpdate(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		memberUpdateService.memberUpdate(member,request);
		String view = "redirect:list";
		return view;
	}

}
