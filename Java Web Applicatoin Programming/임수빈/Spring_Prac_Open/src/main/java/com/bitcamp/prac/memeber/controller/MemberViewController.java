package com.bitcamp.prac.memeber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberViewController {

	@RequestMapping("/member/view")
	public String memberview() {
		return "";
	}

}
