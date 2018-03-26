package com.bitcamp.prac.memeber.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.prac.HomeController;
import com.bitcamp.prac.memeber.model.Member;
import com.bitcamp.prac.memeber.service.MemberLoginService;

@Controller
@RequestMapping("member/login")
public class MemberLoginController {


	@Autowired
	private MemberLoginService memberLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam(value = "member_id", defaultValue = "0") String id,
			@RequestParam(value = "password", required = false) String pw, HttpSession session) {
		
		System.out.println(id);
		System.out.println(pw);

		String view = "redirect:mypage";
		Member member = memberLoginService.loginCheck(id, pw);

		if (member == null) {
			return "member/loginFail";
		}

		member.setMemberPw("");

		session.setAttribute("loginInfo", member);
		System.out.println(session.getAttribute("loginInfo"));

		return view;

	}

}
