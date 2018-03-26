package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberUpdateService;
import com.bitcamp.open.member.service.MemberViewService;

@Controller
@RequestMapping("/member/memberUpdate")
public class memberUpdateController {

	@Autowired
	private MemberUpdateService service;

	private MemberViewService viewService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memberUpdateForm(@RequestParam("member_id") String member_id, Model model) {

		Member member = service.updateSelect(member_id);
			
		model.addAttribute("member", member);

		return "member/memberUpdateForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String memberUpdate(Member member,HttpServletRequest request)throws IllegalStateException, IOException {

		System.out.println(member);
		
		if(member!=null) { //값이 있으면 
		
		int resultCnt = service.updateMemberList(member,request);
		System.out.println(resultCnt);
		if(resultCnt>0) {
			System.out.println("정상적으로 실행");
		}else {
			System.out.println("비어있는 값이 있습니다.");
		}
		}
	    
		return "member/memberUpdate";
	}

}