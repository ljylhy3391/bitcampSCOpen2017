package com.bitcamp.open.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberLoginService;

@Controller
public class MemberMypageController {

	@Autowired
	MemberLoginService service;

	@RequestMapping("/member/mypage")
	public String mypage(HttpSession session, Model model) {

		Member member = (Member) session.getAttribute("loginInfo");

		model.addAttribute("member", member);
		// ModelAndView는 뷰와 모델을 기술할 필요가 있을 때 사용하시면됩니다.
		// Model은 이름 그대로 뷰로 전달할 모델값만 기술 하시면됩니다.
		return "member/mypage";
	}

	// http:localhost:8080/open/member/mypage/ttt
	// ttt값을 받아 쓴다
	@RequestMapping("/mypage/mypage/{id}")
	public String mypageDetail(@PathVariable("id") String id, Model model) { // @PathVariable : 경로의 특정 위치 값이 고정되지 않고 달라질 때 사용하는 것

		Member member = service.selectById(id);

		model.addAttribute("member", member);

		return "member/mypage";
	}
}
