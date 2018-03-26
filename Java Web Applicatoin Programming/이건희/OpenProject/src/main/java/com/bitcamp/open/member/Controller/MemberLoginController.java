package com.bitcamp.open.member.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.Model.Member;
import com.bitcamp.open.member.service.MemberLoginService;
import com.bitcamp.open.member.service.SimpleRegistrationNotifier;

@Controller
@RequestMapping("/member/loginForm")
public class MemberLoginController {

	@Autowired // 객체 xml에 등록후 자동 주입 type에 따라
	private MemberLoginService memberLoginService;
	@Autowired
	private SimpleRegistrationNotifier simpleRegistrationNotifier;

	@RequestMapping(method = RequestMethod.GET)
	public String loginform() {

		return "member/loginForm";

	}

	@RequestMapping(method = RequestMethod.POST)
	// RequestParam 을 이용 넘어오는 파라미터를 처리
	public String login(@RequestParam(value = "member_id", defaultValue = "0") String member_id,

			// 값이 들어 오지 않아도(null) 에러안남 required=false
			@RequestParam(value = "password", required = false) String password, HttpSession session) {

		Member member = memberLoginService.loginChk(member_id, password);
		// null / Member 객체

		if (member == null) {
			return "member/loginFail";
		}
		//로그인시 로그인성공 메일 전송 
		simpleRegistrationNotifier.sendMail(member.getMember_id(),"회원님 로그인이 성공적으로 처리 되었습니다 ");
		
		member.setPassword("");
		// 세션에 데이터 저장
		session.setAttribute("loginInfo", member);
		// 리다이렉트 처리 :mypage로 이동
		String view = "redirect:mypage";// /member/mypage ";//로그인 실패할시 이동할 경로

		return view;

	}
}
