package com.bitcamp.open.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class exampleController {
	@Autowired
	MemberListService service;
	
	@RequestMapping("/member/example")
	public String examplepage(@RequestParam("idx")String idx,Model model) {
		Member member = service.selectIdx(idx);
		
		model.addAttribute("member",member);
		System.out.println("확인!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
		System.out.println(member.getMember_name());
		
		return "member/example";
	}
}
