package com.bitcamp.open.member.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")

public class MemberRegController {

	@Autowired // 같은 type 을 찾아서 주입
	private MemberRegService memberRegService; // 의존주입

	@RequestMapping(method = RequestMethod.GET)
	public String memberRegForm() {

		return "member/memberRegForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(Member member, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException { // 자바빈 처럼 받아서 저장됨
		// 서비스에 회원 데이터 저장 요청
		// 결과 : 1 / 0
		// model 에 저장

		int ResultCnt = memberRegService.memberReg(member, request);
		String msg = "정상적으로 처리 되었습니다";

		if (ResultCnt == 0) {
			// service의 반환값이 0 이면 가입처리가 안됨 return값<
			msg = "가입이 되지 않았습니다.";

		}

		model.addAttribute("msg", msg);

		return "member/memberReg";

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
