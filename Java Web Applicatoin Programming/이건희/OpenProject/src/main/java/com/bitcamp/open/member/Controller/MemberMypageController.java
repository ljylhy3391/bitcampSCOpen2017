package com.bitcamp.open.member.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberLoginService;



@Controller
public class MemberMypageController {

	@Autowired // 객체 xml에 등록후 자동 주입 type에 따라
	private MemberLoginService memberLoginService;
	
	@RequestMapping("/member/mypage")
	public String mypage(HttpSession session,Model model) {
		
	Member member=(Member)session.getAttribute("loginInfo");
	
	//세션 을 가져와 model객체에 저장 
	model.addAttribute("member", member);
	
	
	return "member/mypage";
	}
	
	//http://localhost:8080/open/member/mypage/tttt
	//tttt값을 받아 쓴다 
	@RequestMapping("/mypage/mypage/{id}")
	public String mypageDatatail(@PathVariable("id") String id,
								  Model model) {
		System.out.println(id);
		Member member = memberLoginService.selectById(id);
		
		model.addAttribute("member",member);
		
		
		return "member/mypage2";
	}
}
