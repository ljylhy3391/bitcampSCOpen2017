package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberRegService;
import com.bitcamp.open.member.service.MemberUpdateService;

@Controller
@RequestMapping("/member/memberUpdate")
public class MemberUpdateController {

	// 같은 type을 찾아서 주입
	@Autowired
	private MemberUpdateService memberUpdateService;

		@RequestMapping(method=RequestMethod.GET)
		public String memberUpdate(@RequestParam("member_id") String id, Model model) {
			// sql문을 가져옴 
			
			Member members = memberUpdateService.selectById(id);
			
			model.addAttribute("members", members);
			
			return "/member/memberUpdate";
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String memberUpdate(Member member, Model model, HttpServletRequest request) 
				throws IllegalStateException, IOException {
			// 서비스에  회원 데이터 저장 요청
			// 결과 : 1 / 0
			// model 에 저장
			System.out.println(member);
			
			int resultCnt = memberUpdateService.MemberUpdate(member, request);
			
			String msg = "수정이 완료되었습니다.";
			
			if(resultCnt == 0) {
				msg = "수정이 되지 않았습니다. 담당자에게 문의 해주세요.";		
			
			
			}
			model.addAttribute("msg", msg);
			
			
			return "member/memberUp";
		}
		
		@ExceptionHandler(IOException.class)
		public String ex1(IOException e) {
			return "error/ex1";
		}
		
		@ExceptionHandler(IllegalStateException.class)
		public String ex2(IllegalStateException e) {
			return "error/ex2";
		}

}
