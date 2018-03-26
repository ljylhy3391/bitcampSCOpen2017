package com.bitcamp.prac.memeber.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.prac.memeber.model.Member;
import com.bitcamp.prac.memeber.service.MemberRegService;

@Controller
@RequestMapping("/member/loginReg")
public class MemberRegController {

	@Autowired
	private MemberRegService memberRegService;

	@RequestMapping(method = RequestMethod.GET)
	public String loginRegForm() {
		return "member/loginRegForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginReg(Member member, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {

		int resultCnt = memberRegService.memberReg(member, request);

		String msg = "회원 가입 완료!!";

		if (resultCnt == 0) {
			msg = "회원 가입 실패!!";
		}
		model.addAttribute("msg", msg);

		return "member/loginReg";

	}

}
