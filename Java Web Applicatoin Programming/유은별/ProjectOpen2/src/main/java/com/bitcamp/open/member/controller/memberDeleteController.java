package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.service.MemberDeleteService;

@Controller
public class memberDeleteController {

	@Autowired
	private MemberDeleteService service;
	

	@RequestMapping(value="/member/memberDelete",method=RequestMethod.GET)
	public String memberDelete(@RequestParam("member_id") String member_id){
		
		System.out.println(member_id);
		int resultCnt = service.deleteMemberList(member_id);
		
		if(resultCnt>0) {
			System.out.println("정상적으로 실행");
		}else {
			System.out.println("삭제 노노");
		}
		
		return "redirect:memberList";
	}
}
