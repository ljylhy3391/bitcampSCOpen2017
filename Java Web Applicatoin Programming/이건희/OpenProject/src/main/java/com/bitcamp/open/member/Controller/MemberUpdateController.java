package com.bitcamp.open.member.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberUpdateService;

@Controller
@RequestMapping("/member/updateform")
public class MemberUpdateController {
	@Autowired
	MemberUpdateService service;
	@RequestMapping(method =RequestMethod.GET)
	public String updateform(@RequestParam("idx")String idx,Model model) {
	
		
	Member member = service.UpdateSelect(idx);
	model.addAttribute("member",member);
		
		
		return "member/updateform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String update(Member member,HttpServletRequest request) throws IllegalStateException, IOException {
		String page = "member/update";
		if(member!=null) {
			//값이 있으면 
		int resultCnt = service.Update(member,request);
			if(resultCnt>0) {
				System.out.println("정상적으로 실행 ");
			
			}
			
		}else {
		 System.out.println("비어있는 값이 있습니다");
		}
		
	
		return page;
	
	}

}
