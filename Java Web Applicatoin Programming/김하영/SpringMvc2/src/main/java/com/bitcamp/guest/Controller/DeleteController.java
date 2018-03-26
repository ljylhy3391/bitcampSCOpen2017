package com.bitcamp.guest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.service.MemberListService;

@Controller

public class DeleteController {
	@Autowired
	MemberListService memberlistservice;
	@RequestMapping("/member/delete")
	
	public String delete(@RequestParam("member_id") String member_id) {

		memberlistservice.deleteMember(member_id);
		return "redirect:list";
	}

}
