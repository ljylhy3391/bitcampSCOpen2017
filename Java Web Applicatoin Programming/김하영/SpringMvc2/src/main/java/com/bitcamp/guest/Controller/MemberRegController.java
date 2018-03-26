package com.bitcamp.guest.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.guest.model.Member;
import com.bitcamp.guest.service.MemberRegService;

@Controller
@RequestMapping("/member/memberRegForm")
public class MemberRegController {

	@Autowired
	MemberRegService memberService;
	
	
	
	


	@RequestMapping(method=RequestMethod.GET)
	public String memberRegForm() {
		
		String view = "member/memberRegForm";
		return view;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(Member member, Model model,HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println("?");
		
		int resultCnt = memberService.insertoService(member,request);	
		String msg ="정상적으로 처리되지 않았습니다";
		if(resultCnt>0) {
		
			msg="정상적으로 처리 되었습니다";
		}
		
		model.addAttribute("msg",msg);
		String view = "member/memberReg";
		
		model.addAttribute("member",member);
		
		return view;
	}
	
	
	
	
	
}
