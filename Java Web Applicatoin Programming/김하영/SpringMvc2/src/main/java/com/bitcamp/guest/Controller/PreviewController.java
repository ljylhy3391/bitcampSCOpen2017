package com.bitcamp.guest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.model.Member;
import com.bitcamp.guest.service.MemberListService;

@Controller
public class PreviewController {

	@Autowired
	private MemberListService memberListService;
	//@RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/member/preview")
	public String Preview(@RequestParam("member_id")String member_id,Model model) {
		
		Member member=memberListService.regMember(member_id);
		
		model.addAttribute("member", member);
		return "member/preview";
	}

}
