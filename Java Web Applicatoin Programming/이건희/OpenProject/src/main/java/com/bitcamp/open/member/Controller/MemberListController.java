package com.bitcamp.open.member.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService service;
	
	@RequestMapping("member/memberList")
	public String memberList(Model model ) {
		
		List<Member> member =service.getMemberList();
		model.addAttribute("list", member);
		
		return "member/memberList";
	}
}
